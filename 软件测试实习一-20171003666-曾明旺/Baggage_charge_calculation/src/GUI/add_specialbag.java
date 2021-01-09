package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class add_specialbag extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public add_specialbag(JTextArea textarea) {
		JTextArea a= textarea;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请选择行李类型：");
		label.setBounds(14, 31, 128, 18);
		contentPane.add(label);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"电动轮椅", "机械假肢", "呼吸机", "骨灰", "高尔夫球包", "保龄球", "皮划艇", "独木舟", "撑杆", "标枪", "睡袋", "渔具", "小动物","小型电器或仪器"}));
		comboBox.setBounds(156, 28, 154, 24);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("件数：");
		label_1.setBounds(31, 108, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("重量：");
		label_2.setBounds(31, 178, 72, 18);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(117, 105, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 175, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bag_name=comboBox.getSelectedItem().toString();
				String bag_num=textField.getText();
				String bag_weight=textField_1.getText();
				String bag_info=bag_name+"*"+bag_num+"*"+bag_weight+"KG"+"\n";
				a.append(bag_info);
				setVisible(false);
			}
		});
		button.setBounds(152, 254, 113, 27);
		contentPane.add(button);
	}

}
