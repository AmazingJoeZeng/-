package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JTextPane;

public class HomePage {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("座舱类型：");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(38, 31, 102, 18);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("旅客类型：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 127, 102, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("会员类型：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(38, 223, 102, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("航班类型：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(38, 319, 102, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("航班票价：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(38, 415, 102, 18);
		frame.getContentPane().add(label_3);
		
		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"豪华头等舱", "头等舱", "公务舱", "悦享经济舱", "超级经济舱", "经济舱", "经济舱A（国际运输）", "经济舱B（国际运输）"}));
		comboBox.setBounds(160, 25, 173, 24);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"成人", "儿童", "婴儿"}));
		comboBox_1.setBounds(160, 122, 173, 24);
		frame.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"凤凰知音终身白金卡", "白金卡", "凤凰知音金卡", "银卡", "星空联盟金卡", "普通会员"}));
		comboBox_2.setBounds(160, 219, 173, 24);
		frame.getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"国内运输", "国际运输区域一", "国际运输区域二", "国际运输区域三", "国际运输区域四", "国际运输区域五"}));
		comboBox_3.setBounds(160, 316, 173, 24);
		frame.getContentPane().add(comboBox_3);
		
		textField = new JTextField();
		textField.setBounds(160, 414, 173, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("如有特殊行李请点这里……");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				special_bag s_bag=new special_bag();
				s_bag.setVisible(true);
			}
		});
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("华文楷体", Font.BOLD, 20));
		label_4.setBounds(38, 500, 265, 18);
		frame.getContentPane().add(label_4);
		
		JButton btnNewButton = new JButton("计算总费用");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String air_type=comboBox_3.getSelectedItem().toString();
				if(air_type.equals("国内运输")) {
					int []free_domestic=get_free_domestic();
					double over_price=over_price(free_domestic)+special_bag.over_free_price;
					String out="应付行李总费用为："+over_price;
					JOptionPane.showMessageDialog(null, out);
					textArea.setText("");
				}
				else {
					int[] free_abroad=get_free_abroad();
					double over_price=over_price_abroad(free_abroad,air_type)+Integer.parseInt(textField.getText())*0.015*special_bag.over_free_weight+special_bag.over_free_price;
					String out="应付行李总费用为："+over_price;
					JOptionPane.showMessageDialog(null, out);
					textArea.setText("");
				}
				
			}
		});
		btnNewButton.setBounds(492, 491, 239, 40);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setToolTipText("行李信息");
		textArea.setBounds(398, 93, 391, 340);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("添加行李");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_bag bag=new add_bag(textArea);
				bag.setVisible(true);
			}
		});
		button.setBounds(398, 29, 113, 27);
		frame.getContentPane().add(button);
		
	}
	
	//国内免费托运额度
	public int[] get_free_domestic() {
		String person_type=comboBox_1.getSelectedItem().toString();
		if(person_type.equals("成人")||person_type.equals("儿童")) {
			String VIP_type=comboBox_2.getSelectedItem().toString();
			String Cockpit_type=comboBox.getSelectedItem().toString();
			int VIP_free=get_VIP_free(VIP_type);
			int Cockpit_free=get_cockpit_free(Cockpit_type)-special_bag.over_free_weight;
			int[] result=new int[2];
			result[0]=Cockpit_free;
			result[1]=VIP_free;
			return result;
		}
		if(person_type.equals("婴儿")) {
			String VIP_type=comboBox_2.getSelectedItem().toString();
			int VIP_free=get_VIP_free(VIP_type);
			int[] result=new int[2];
			result[0]=10;
			result[1]=VIP_free;
			return result;
		}
		int[] erro= {0,0};
		return erro;
	}
	
	//国外免费托运额度
	public int[] get_free_abroad() {
		String Cockpit_type=comboBox.getSelectedItem().toString();
		if(Cockpit_type.equals("豪华头等舱")||Cockpit_type.equals("头等舱")||Cockpit_type.equals("公务舱")) {
			String person_type=comboBox_1.getSelectedItem().toString();
			if(person_type.equals("成人")||person_type.equals("儿童")) {
				int[] result=new int[2];
				result[0]=32;
				result[1]=32;
				return result;
			}
			if(person_type.equals("婴儿")) {
				int [] result=new int[1];
				result[0]=23;
				return result;
			}
		}
		if(Cockpit_type.equals("悦享经济舱")||Cockpit_type.equals("超级经济舱")) {
			int[] result=new int[2];
			result[0]=32;
			result[1]=32;
			return result;
		}
		if(Cockpit_type.equals("经济舱A（国际运输）")){
			int [] result=new int[1];
			result[0]=23;
			return result;
		}
		if(Cockpit_type.equals("经济舱B（国际运输）")){
			int [] result=new int[2];
			result[0]=23;
			result[1]=23;
			return result;
		}
		int[] erro= {0,0};
		return erro;
	}
	
	public int get_VIP_free(String VIP_type) {
		if(VIP_type.equals("凤凰知音终身白金卡")) {
			int result=30;
			return result;
		}
		if(VIP_type.equals("白金卡")) {
			int result=30;
			return result;
		}
		if(VIP_type.equals("凤凰知音金卡")) {
			int result=20;
			return result;
		}
		if(VIP_type.equals("银卡")) {
			int result=20;
			return result;
		}
		if(VIP_type.equals("星空联盟金卡")) {
			int result=20;
			return result;
		}
		if(VIP_type.equals("普通会员")) {
			int result=0;
			return result;
		}
		return 0;
	}
	
	public int get_cockpit_free(String Cockpit_type) {
		if(Cockpit_type.equals("豪华头等舱")) {
			int result=40;
			return result;
		}
		if(Cockpit_type.equals("头等舱")) {
			int result=40;
			return result;
		}
		if(Cockpit_type.equals("公务舱")) {
			int result=30;
			return result;
		}
		if(Cockpit_type.equals("经济舱")) {
			int result=20;
			return result;
		}
		if(Cockpit_type.equals("悦享经济舱")) {
			int result=20;
			return result;
		}
		if(Cockpit_type.equals("超级经济舱")) {
			int result=20;
			return result;
		}
		return 0;
	}
	
	public double over_price(int[] free_quota) {
		String bags_info=textArea.getText();                  //行李信息
		if(textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "未输入航班票价", "提示信息", JOptionPane.ERROR_MESSAGE);
		}
		int tic_price=Integer.parseInt(textField.getText());        //票价
		String[] bag_line=bags_info.split("\n");                   //按行划分
		int bag_num=bag_line.length;                              //有多少个行李
		int cockpit_free=free_quota[0];                           //座舱免费行李额
		int VIP_free=free_quota[1];                              //会员免费行李额
		int sum_weight=0;                                       //初始化总重为0
		for(int i=0;i<bag_num;i++) {                            //遍历全部行李
			bag_line[i]=bag_line[i].replaceAll("\n","");
			String[] bag_info=bag_line[i].split("\\*");           //按*划分出长宽高重
			int bag_len=Integer.parseInt(bag_info[0]);
			int bag_wid=Integer.parseInt(bag_info[1]);
			int bag_hei=Integer.parseInt(bag_info[2]);
			int bag_weight=Integer.parseInt(bag_info[3]);
			if(bag_len>100||bag_wid>60||bag_hei>40) {
				JOptionPane.showMessageDialog(null, "国内运输尺寸错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
			}
			sum_weight=sum_weight+bag_weight;
		}
		if(cockpit_free>=sum_weight) {
			return 0;
		}
		int [] bags_weight=new int[bag_num];            //行李的重量数组
		for(int i=0;i<bag_num;i++) {
			bag_line[i]=bag_line[i].replaceAll("\n","");
			String[] bag_info=bag_line[i].split("\\*");
			int bag_len=Integer.parseInt(bag_info[0]);
			int bag_wid=Integer.parseInt(bag_info[1]);
			int bag_hei=Integer.parseInt(bag_info[2]);
			int bag_weight=Integer.parseInt(bag_info[3]);
			bags_weight[i]=bag_weight;
		}
		Arrays.sort(bags_weight);                       //排序
		int select_weight=0;                           //找到离会员免费行李额最相近的一个行李
		for(int i=0;i<bag_num-1;i++) {
			if(bags_weight[i]<=VIP_free&&VIP_free<bags_weight[i+1]) {
				select_weight=bags_weight[i];
			}
			if(VIP_free>=bags_weight[bag_num-1]) {
				select_weight=bags_weight[bag_num-1];
			}
		}
		int final_weight=0;
		int temp_i=0;
		for(int i=0;i<bag_num;i++) {
			bag_line[i]=bag_line[i].replaceAll("\n","");
			String[] bag_info=bag_line[i].split("\\*");
			int bag_weight=Integer.parseInt(bag_info[3]);
			if(bag_weight==select_weight) {
				temp_i=i;
				break;
			}
		}
		for(int i=0;i<bag_num;i++) {
			bag_line[i]=bag_line[i].replaceAll("\n","");
			String[] bag_info=bag_line[i].split("\\*");
			int bag_len=Integer.parseInt(bag_info[0]);
			int bag_wid=Integer.parseInt(bag_info[1]);
			int bag_hei=Integer.parseInt(bag_info[2]);
			int bag_weight=Integer.parseInt(bag_info[3]);
			if(i==temp_i) {
				bag_weight=0;
			}
			final_weight=final_weight+bag_weight;
		}
		if(cockpit_free>=final_weight) {
			return 0;
		}
		else {
			int over_weight=final_weight-cockpit_free;
			double over_price=tic_price*0.015*over_weight;
			return over_price;
		}
	}
	
	public double over_price_abroad(int[] free_quota,String air_type) {
		if(air_type.equals("国际运输区域一")) {
			int[]over_bag=over_size_num(free_quota);                //获取超重，超尺寸代号
			int free_bag_num=free_quota.length;           //免费的行李的个数
			double over_price=0;
			for(int i=0;i<over_bag.length;i++) {
				if(over_bag[i]==0) {
					over_price=over_price+380;
				}
				if(over_bag[i]==1) {
					over_price=over_price+980;
				}
				if(over_bag[i]==2) {
					over_price=over_price+980;
				}
				if(over_bag[i]==3) {
					over_price=over_price+1400;
				}
				if(over_bag[i]==4) {
					over_price=over_price+0;         //免费行李额
				}
				if(over_bag[i]==5) {
					over_price=over_price+0;         //免费行李额用完后，超出的额外尺寸合规的
				}
			}
			if(over_bag.length>free_bag_num) {
				int temp_num=over_bag.length-free_bag_num;
				if(temp_num==1) {
					over_price=over_price+1400;
				}
				if(temp_num==2) {
					over_price=over_price+1400+2000;
				}
				if(temp_num>=3) {
					over_price=over_price+1400+2000+3000*(temp_num-2);
				}
			}
			return over_price;
		}
		if(air_type.equals("国际运输区域二")) {
			int[]over_bag=over_size_num(free_quota);
			int free_bag_num=free_quota.length;
			double over_price=0;
			for(int i=0;i<over_bag.length;i++) {
				if(over_bag[i]==0) {
					over_price=over_price+280;
				}
				if(over_bag[i]==1) {
					over_price=over_price+690;
				}
				if(over_bag[i]==2) {
					over_price=over_price+690;
				}
				if(over_bag[i]==3) {
					over_price=over_price+1100;
				}
				if(over_bag[i]==4) {
					over_price=over_price+0;         //免费行李额
				}
				if(over_bag[i]==5) {
					over_price=over_price+0;         //免费行李额用完后，超出的额外尺寸合规的
				}
			}
			if(over_bag.length>free_bag_num) {
				int temp_num=over_bag.length-free_bag_num;
				if(temp_num==1) {
					over_price=over_price+1100;
				}
				if(temp_num==2) {
					over_price=over_price+1100+1100;
				}
				if(temp_num>=3) {
					over_price=over_price+1100+1100+1590*(temp_num-2);
				}
			}
			return over_price;
		}
		if(air_type.equals("国际运输区域三")) {
			int[]over_bag=over_size_num(free_quota);
			int free_bag_num=free_quota.length;
			double over_price=0;
			for(int i=0;i<over_bag.length;i++) {
				if(over_bag[i]==4||over_bag[i]==5) {
					over_price=over_price+0;         //免费行李额或免费行李额用完后，超出的额外尺寸合规的
				}
				else {
					over_price=over_price+520;
				}
			}
			if(over_bag.length>free_bag_num) {
				int temp_num=over_bag.length-free_bag_num;
				if(temp_num==1) {
					over_price=over_price+1170;
				}
				if(temp_num==2) {
					over_price=over_price+1170+1170;
				}
				if(temp_num>=3) {
					over_price=over_price+1170+1170+1590*(temp_num-2);
				}
			}
			return over_price;
		}
		if(air_type.equals("国际运输区域四")) {
			int[]over_bag=over_size_num(free_quota);
			int free_bag_num=free_quota.length;
			double over_price=0;
			for(int i=0;i<over_bag.length;i++) {
				if(over_bag[i]==0) {
					over_price=over_price+690;
				}
				if(over_bag[i]==1) {
					over_price=over_price+1040;
				}
				if(over_bag[i]==2) {
					over_price=over_price+1040;
				}
				if(over_bag[i]==3) {
					over_price=over_price+2050;
				}
				if(over_bag[i]==4) {
					over_price=over_price+0;         //免费行李额
				}
				if(over_bag[i]==5) {
					over_price=over_price+0;         //免费行李额用完后，超出的额外尺寸合规的
				}
			}
			if(over_bag.length>free_bag_num) {
				int temp_num=over_bag.length-free_bag_num;
				if(temp_num==1) {
					over_price=over_price+1380;
				}
				if(temp_num==2) {
					over_price=over_price+1380+1380;
				}
				if(temp_num>=3) {
					over_price=over_price+1380+1380+1590*(temp_num-2);
				}
			}
			return over_price;
		}
		if(air_type.equals("国际运输区域五")) {
			int[]over_bag=over_size_num(free_quota);
			int free_bag_num=free_quota.length;
			double over_price=0;
			for(int i=0;i<over_bag.length;i++) {
				if(over_bag[i]==0) {
					over_price=over_price+210;
				}
				if(over_bag[i]==1) {
					over_price=over_price+520;
				}
				if(over_bag[i]==2) {
					over_price=over_price+520;
				}
				if(over_bag[i]==3) {
					over_price=over_price+830;
				}
				if(over_bag[i]==4) {
					over_price=over_price+0;         //免费行李额
				}
				if(over_bag[i]==5) {
					over_price=over_price+0;         //免费行李额用完后，超出的额外尺寸合规的
				}
			}
			if(over_bag.length>free_bag_num) {
				int temp_num=over_bag.length-free_bag_num;
				if(temp_num==1) {
					over_price=over_price+830;
				}
				if(temp_num==2) {
					over_price=over_price+830+1100;
				}
				if(temp_num>=3) {
					over_price=over_price+830+1100+1590*(temp_num-2);
				}
			}
			return over_price;
		}
		return 0;
	}
	
	public int[] over_size_num(int[] free_quota) {
		String bags_info=textArea.getText();                  //行李信息
		if(textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "未输入航班票价", "提示信息", JOptionPane.ERROR_MESSAGE);
		}
		int free_bag_num=free_quota.length;                      //免费行李个数
		
		//int tic_price=Integer.parseInt(textField.getText());        //票价
		String[] bag_line=bags_info.split("\n");                   //按行划分
		int bag_num=bag_line.length;                              //有多少个行李
		int[] over_index=new int[bag_num];
		for(int i=0;i<bag_num;i++) {                            //遍历全部行李
			bag_line[i]=bag_line[i].replaceAll("\n","");
			String[] bag_info=bag_line[i].split("\\*");           //按*划分出长宽高重
			int bag_len=Integer.parseInt(bag_info[0]);
			int bag_wid=Integer.parseInt(bag_info[1]);
			int bag_hei=Integer.parseInt(bag_info[2]);
			int bag_weight=Integer.parseInt(bag_info[3]);
			int size_sum=bag_len+bag_wid+bag_hei;
			if(free_bag_num>0) {
			    if(bag_weight>2&&bag_weight<=free_quota[0]&&size_sum>=60&size_sum<=158) {
				free_bag_num=free_bag_num-1;
				over_index[i]=4;
				continue;
			}
			}
			if(bag_weight>23&&bag_weight<=28&&size_sum>=60&size_sum<=158) {
				over_index[i]=0;                     //序号为0的超重超尺寸的情况
			}
			if(bag_weight>29&&bag_weight<=32&&size_sum>=60&size_sum<=158) {
				over_index[i]=1;                     //序号为1的超重超尺寸的情况
			}
			if(bag_weight>2&&bag_weight<=23&&size_sum>158&size_sum<=203) {
				over_index[i]=2;                      //序号为2的超重超尺寸的情况
			}
			if(bag_weight>23&&bag_weight<=32&&size_sum>158&size_sum<=203) {
				over_index[i]=3;                     //序号为3的超重超尺寸的情况
			}
			if(bag_weight<2||bag_weight>32||size_sum<60||size_sum>203) {
				JOptionPane.showMessageDialog(null, "国内运输尺寸错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
			}
			//当免费行李额用完后，超出的额外行李
			if(bag_weight>2&&bag_weight<=free_quota[0]&&size_sum>=60&size_sum<=158) {
				over_index[i]=5;
			}
		}
		return over_index;
	}
}
