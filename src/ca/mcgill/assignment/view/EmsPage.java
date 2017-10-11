package ca.mcgill.assignment.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ca.mcgill.assignment.controller.EmsController;
import ca.mcgill.assignment.controller.InvalidInputException;
import ca.mcgill.assignment.model.EMS;

public class EmsPage {

	public JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField,textField_1;
	private JTable table;
    private JRadioButton rdbtnScheduledElection,rdbtnByElection;
    private JDateChooser dateChooser;
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmsPage window = new EmsPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public EmsPage() {
		initialize();
		setVisible();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Election Management System");
		frame.setResizable(false);
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblElectionManagementSystem = new JLabel("Election Management System");
		lblElectionManagementSystem.setForeground(Color.RED);
		lblElectionManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblElectionBody = new JLabel("Election Body");
		lblElectionBody.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblElectionPosition = new JLabel("Election Position");
		lblElectionPosition.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		rdbtnScheduledElection = new JRadioButton("Scheduled Election");
		buttonGroup.add(rdbtnScheduledElection);
		
		rdbtnByElection = new JRadioButton("By Election");
		buttonGroup.add(rdbtnByElection);
		
		JLabel lblTypeOfElection = new JLabel("Type Of Election");
		lblTypeOfElection.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblElectionDate = new JLabel("Election Date");
		lblElectionDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
					SubmitActionPerformed(evt);
				
			}
		});

			
		
		JButton btnRefresh = new JButton("Update");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				UpdateActionPerformed(evt);			}
		});
		
		JButton btnExit = new JButton("Delete\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				DeleteActionPerformed(evt);
			
			}

			
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		dateChooser = new JDateChooser();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator_5 = new JSeparator();
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblElectionBody, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTypeOfElection)
										.addComponent(rdbtnScheduledElection))
									.addGap(44)
									.addComponent(rdbtnByElection)
									.addGap(31)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblElectionDate, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(87)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnSubmit)
									.addGap(18)
									.addComponent(btnRefresh)
									.addGap(18)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblElectionPosition, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
						.addComponent(separator_5))
					.addContainerGap(340, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(254, Short.MAX_VALUE)
					.addComponent(lblElectionManagementSystem, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(224))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblElectionManagementSystem, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElectionBody)
						.addComponent(lblElectionPosition))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdbtnByElection)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTypeOfElection)
								.addComponent(lblElectionDate))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnScheduledElection)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSubmit)
										.addComponent(btnRefresh)
										.addComponent(btnExit)))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Election Body", "Election Position", "Election Type", "Election Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setLayout(gl_panel);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		EMS e2 = EmsController.loadData();
		if(e2!=null)
		{
		int size = e2.getElectionBodies().size();
		int i = 0,j=0;
		while(i<size)
		{	
		model.addRow(new Object[]{e2.getElectionBody(i).getNameOfBody(),e2.getElectionBody(i).getPosition(0).getNameOfPosition(),e2.getElection(j).getTypeOfElection(),e2.getElection(j).getElectionDate()});
		i++;
		j++;
		}
		}
	}

	private void DeleteActionPerformed(ActionEvent evt) {
			int rownum = table.getSelectedRow();
			EmsController.deleteElection(rownum);
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setRowCount(0);
			EMS e2 = EmsController.loadData();
			if(e2!=null)
			{
			int size = e2.getElectionBodies().size();
			int i = 0,j=0;
			while(i<size)
			{	
			model.addRow(new Object[]{e2.getElectionBody(i).getNameOfBody(),e2.getElectionBody(i).getPosition(0).getNameOfPosition(),e2.getElection(j).getTypeOfElection(),e2.getElection(j).getElectionDate()});
			i++;
			j++;
			}
			}
	}
	
	
	private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {
		int rownum = table.getSelectedRow();
		String ElecBody = table.getValueAt(rownum, 0).toString();
		String ElecPos = table.getValueAt(rownum, 1).toString();
		String TypeOfElection= table.getValueAt(rownum, 2).toString();
		String EDate = table.getValueAt(rownum,3).toString();
		try{
		EmsController.updateElection(rownum,TypeOfElection,EDate,ElecPos,ElecBody);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,e.getMessage());
			//System.out.println(e.getMessage());
		}
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		EMS e2 = EmsController.loadData();
		if(e2!=null)
		{
		int size = e2.getElectionBodies().size();
		int i = 0,j=0;
		while(i<size)
		{	
		model.addRow(new Object[]{e2.getElectionBody(i).getNameOfBody(),e2.getElectionBody(i).getPosition(0).getNameOfPosition(),e2.getElection(j).getTypeOfElection(),e2.getElection(j).getElectionDate()});
		i++;
		j++;
		}
		}
	}
	
	private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {

	//	String ElecBody = comboBox.getSelectedItem().toString();
		int flag = 1,count = 1;
		String ElecBody = textField.getText();
		if(ElecBody.equalsIgnoreCase(null))
		{
			System.out.println("Please Select Election Body");
			flag=count = 0;
			
	}
		
		
		//For Positions
		String ElecPos = textField_1.getText();
	if(ElecPos.equalsIgnoreCase(null))
	{
		System.out.println("Please Select Election Position");
		flag=count = 0;
	}
	
		
		//For Type of Election
	String TypeOfElection=null;
	if(rdbtnByElection.isSelected()==true)
	{
		TypeOfElection = rdbtnByElection.getText();
	}
	else if(rdbtnScheduledElection.isSelected()==true)
	{
		TypeOfElection = rdbtnScheduledElection.getText();
	}
	else
	{
		System.out.println("Please Select the Election Type");
		flag=count = 0;
	}
	//For Date
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	String ElecDate=null;
	try
	{
	ElecDate = dateformat.format(dateChooser.getDate());
	}
	catch(NullPointerException e)
	{
		
	}
	
	
	//System.out.println(testdate);
	
	if (ElecDate == null)
	{
		System.out.println("Please Select a Date");
		flag=count = 0;
	}
	
	//if(flag == 1)
	//{
		try {
			EmsController.createElection(TypeOfElection, ElecDate, ElecPos, ElecBody);
		}
	//	catch (InvalidInputException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(frame,e.getMessage());
			

		}
	//}
	
if(count == 1 && flag == 1)
{
	
	DefaultTableModel model = (DefaultTableModel)table.getModel();
	model.setRowCount(0);
	EMS e2 = EmsController.loadData();
	if(e2!=null)
	{
	int size = e2.getElectionBodies().size();
	int i = 0,j=0;
	while(i<size)
	{	
	model.addRow(new Object[]{e2.getElectionBody(i).getNameOfBody(),e2.getElectionBody(i).getPosition(0).getNameOfPosition(),e2.getElection(j).getTypeOfElection(),e2.getElection(j).getElectionDate()});
	i++;
	j++;
	}
	}
}	
	refreshData();
	}
	
	public void refreshData()
	{
		textField.setText(null);
		textField_1.setText(null);
		dateChooser.setDate(null);
		buttonGroup.clearSelection();
	}
	
	public void setVisible()
	{
		frame.setVisible(true);
	}
}
