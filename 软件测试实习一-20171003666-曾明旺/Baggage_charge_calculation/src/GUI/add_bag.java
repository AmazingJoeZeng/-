package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class add_bag extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public add_bag(JTextArea textArea) {
		JTextArea a=textArea;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请在下方完善行李信息");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(14, 23, 260, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("长：");
		label_1.setBounds(29, 101, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("宽：");
		label_2.setBounds(29, 168, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("高：");
		label_3.setBounds(29, 226, 72, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("重量：");
		label_4.setBounds(29, 294, 72, 18);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(93, 98, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 165, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 223, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(93, 291, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String length=textField.getText();
				String width=textField_1.getText();
				String height=textField_2.getText();
				String weight=textField_3.getText();
				if(!is_leg(length,width,height,weight)) {
					String bag_info=length+"*"+width+"*"+height+"*"+weight;
					a.append(bag_info+"\n");
				}
				setVisible(false);
			}
		});
		button.setBounds(66, 369, 113, 27);
		contentPane.add(button);
	}
	
	public boolean is_leg(String len,String wid,String hei,String wei) {
		int length=Integer.parseInt(len);
		int width=Integer.parseInt(wid);
		int height=Integer.parseInt(hei);
		int weight=Integer.parseInt(wei);
		int sum=length+width+height;
		if(sum<60||sum>203) {
			show_dialog("尺寸");
			return true;
		}
		if(weight<2||weight>32) {
			show_dialog("重量");
			return true;
		}
		return false;
	}
	
	public void show_dialog(String a) {
		Dialog d = new Dialog(this, "提示信息", true);          //弹出的对话框
        d.setBounds(400, 200, 350, 150);               //设置弹出对话框的位置和大小
        d.setLayout(new FlowLayout());               //设置弹出对话框的布局为流式布局
        String b=a+"不合规，无法计价！";
        Label lab = new Label(b);                   //创建lab标签填写提示内容
        Button okBut = new Button("确定");
        d.add(lab);                                      //将标签添加到弹出的对话框内
        d.add(okBut);
        okBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.setVisible(true);
	}

}
