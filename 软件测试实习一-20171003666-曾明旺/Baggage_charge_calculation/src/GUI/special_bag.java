package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class special_bag extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	public static int over_free_weight=0;
	public static double over_free_price=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					special_bag frame = new special_bag();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public special_bag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("点击添加特殊行李");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_specialbag s_bag=new add_specialbag(textArea);
				s_bag.setVisible(true);
			}
		});
		button.setBounds(24, 31, 218, 27);
		contentPane.add(button);
		
		textArea = new JTextArea();
		textArea.setBounds(24, 88, 398, 438);
		contentPane.add(textArea);
		
		JButton button_1 = new JButton("提交");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				free_weight_and_cost();
				String out="提交完毕！";
				JOptionPane.showMessageDialog(null, out);
				setVisible(false);
			}
		});
		button_1.setBounds(152, 560, 113, 27);
		contentPane.add(button_1);
	}
	
	public void free_weight_and_cost() {
		String bags_info=textArea.getText();
		String[] bag_line=bags_info.split("\n");                   //按行划分
		int bag_num=bag_line.length;                               //特殊行李数量
		int free_weight=0;
		double over_cost=0;
		for(int i=0;i<bag_num;i++) {                            //遍历全部行李
			bag_line[i]=bag_line[i].replaceAll("\n","");
			bag_line[i]=bag_line[i].replaceAll("KG", "");
			String[] bag_info=bag_line[i].split("\\*");           //按*划分出物品，重量和件数
			if(bag_info[0].equals("高尔夫球包")||bag_info[0].equals("保龄球")||bag_info[0].equals("睡袋")||bag_info[0].equals("渔具")) {
				free_weight=free_weight+Integer.parseInt(bag_info[1])*Integer.parseInt(bag_info[2]);
			}
			if(bag_info[0].equals("电动轮椅")||bag_info[0].equals("机械假肢")||bag_info[0].equals("呼吸机")||bag_info[0].equals("骨灰")) {
				free_weight=free_weight+0;
			}
			if(bag_info[0].equals("皮划艇")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=23) {
					over_cost=over_cost+2600*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight>32&&bag_weight<=45) {
					over_cost=over_cost+5200*num;
				}
				if(bag_weight<2||bag_weight>45) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(bag_info[0].equals("独木舟")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=23) {
					over_cost=over_cost+2600*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight>32&&bag_weight<=45) {
					over_cost=over_cost+5200*num;
				}
				if(bag_weight<2||bag_weight>45) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(bag_info[0].equals("撑杆")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=23) {
					over_cost=over_cost+1300*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+2600*num;
				}
				if(bag_weight>32&&bag_weight<=45) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight<2||bag_weight>45) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(bag_info[0].equals("标枪")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=23) {
					over_cost=over_cost+1300*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+2600*num;
				}
				if(bag_weight>32&&bag_weight<=45) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight<2||bag_weight>45) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(bag_info[0].equals("小动物")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=8) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight>8&&bag_weight<=23) {
					over_cost=over_cost+5200*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+7800*num;
				}
				if(bag_weight<2||bag_weight>32) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(bag_info[0].equals("小型电器或仪器")) {
				int bag_weight=Integer.parseInt(bag_info[2]);
				int num=Integer.parseInt(bag_info[1]);
				if(bag_weight>=2&&bag_weight<=23) {
					over_cost=over_cost+490*num;
				}
				if(bag_weight>23&&bag_weight<=32) {
					over_cost=over_cost+3900*num;
				}
				if(bag_weight<2||bag_weight>32) {
					JOptionPane.showMessageDialog(null, "特殊行李重量错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}	
	    }
		over_free_weight=free_weight;
		over_free_price=over_cost;
	}

}
