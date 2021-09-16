package programlamadilleri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class programlamadilleri extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btn_yeni_soru, btn_bos_birak;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	
        
	programlamadilleri(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btn_yeni_soru = new JButton("Sonraki Soru");
		btn_bos_birak = new JButton("Boş bırak");
		btn_yeni_soru.addActionListener(this);
		btn_bos_birak.addActionListener(this);
		add(btn_yeni_soru);
		add(btn_bos_birak);
		set();
		label.setBounds(30, 40, 450, 20);
		
                
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btn_yeni_soru.setBounds(100, 240, 100, 30);
		btn_bos_birak.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_yeni_soru) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btn_yeni_soru.setEnabled(false);
				btn_bos_birak.setText("Sonuç");
			}
		}
		if (e.getActionCommand().equals("Boş bırak")) {
			JButton bk = new JButton("Boş bırak" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btn_bos_birak.setText("Sonuç");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Boş bırak" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Sonuç")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this," Toplam soru sayısı= 10"
                                + "    " + "Doğru cevaplanılan soru sayısı= " + count);
                     	System.exit(0);
		}
	}

	
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("1) ((5-(25/9)) / (2/3))-(1/3) işleminin sonucu kaçtır?");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("3");
			radioButton[3].setText("4");
                       
		}
		if (current == 1) {
			label.setText("2) ((60^2)*3) / 15^3 işleminin sonucu kaçtır ?");
			radioButton[0].setText("2,4");
			radioButton[1].setText("2,6");
			radioButton[2].setText("2.8");
			radioButton[3].setText("3,2");
		}
		if (current == 2) {
			label.setText("3) (√48 + √75) / (√108 - √27) işleminin sonucu kaçtır ?");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("3");
			radioButton[3].setText("4");
		}
		if (current == 3) {
			label.setText("4) (6! + 7!) / ((4!)^2 ) işleminin sonucu kaçtır ?");
			radioButton[0].setText("10");
			radioButton[1].setText("12");
			radioButton[2].setText("15");
			radioButton[3].setText("18");
		}
		if (current == 4) {
			label.setText("5) x/y,x-y,x sayıları küçükten büyüğe doğru sıralanmış\n" +
"ardışık üç çift tam sayıdır. Buna göre x+y toplamı kaçtır ?");
			radioButton[0].setText("8");
			radioButton[1].setText("10");
			radioButton[2].setText("12");
			radioButton[3].setText("14");
		}
		if (current == 5) {
			label.setText("6) a ve b birbirinden farklı pozitif tam sayılar olmak üzere EKOK(a,b)\n" +
"bir asal sayıya eşittir.\n" +
"Buna göre,\n" +
"1.    a ve b aralarında asal sayılardır.\n" +
"2.    a + b toplamı bir tek sayıdır.\n" +
"3.    a.b çarpımı bir tek sayıdır.\n" +
"İfadelerinden hangileri her zaman doğrudur?");
			radioButton[0].setText("Yalnız 1");
			radioButton[1].setText("Yalnız 2");
			radioButton[2].setText("Yalnız 3");
			radioButton[3].setText("1 ve 2");
		}
		if (current == 6) {
			label.setText("7) (xz-yz + xy – y^2) / (x^2 – xy + xz – yz) ifadesinin sadeleştirilmiş\n" +
"biçimi aşağıdakilerden hangisidir?");
			radioButton[0].setText("(z-y) / (x-z )");
			radioButton[1].setText("(y+z) / (x+z)");
			radioButton[2].setText("(x+z) / (y+z)");
			radioButton[3].setText(" x / (x+y) ");
		}
		if (current == 7) {
			label.setText(" a,b ve c pozitif gerçel sayıları için \n" +
"        (a+c) / (b+2) = c/b\n" +
"         a/b =c\n" +
"eşitlikleri veriliyor.\n" +
"Buna göre, b kaçtır?");
			radioButton[0].setText("√2");
			radioButton[1].setText("√3");
			radioButton[2].setText("√6 I");
			radioButton[3].setText("2");
		}
		if (current == 8) {
			label.setText("9) (1/√a)- (2/√9a) =1\n" +
"olduğuna göre, a kaçtır?");
			radioButton[0].setText("1/3");
			radioButton[1].setText("2/3");
			radioButton[2].setText("1/4");
			radioButton[3].setText("1/9");
		}
		if (current == 9) {
			label.setText("10) Sıfırdan farklı x,y ve gerçel sayılarının mutlak değerleri birbirinden farklı olmak üzere,\n" +
"|x+y| = |x|-|y|\n" +
"|y+z| = |y|+|z|\n" +
"Eşitlikleri sağlanmaktadır.\n" +
"x>0 olduğuna göre,\n" +
"1.    ( x/ (x+y) ) <1\n" +
"2.    ( y/ (y+z) ) <1\n" +
"3.    ( z/ (x+z) )<1\n" +
"İfadelerinden hangileri her zaman doğrudur?");
			radioButton[0].setText("Yalnız 1");
			radioButton[1].setText("Yalnız 2");
			radioButton[2].setText("Yalnız 3");
			radioButton[3].setText("1 ve 3");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	
	boolean check() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[0].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new programlamadilleri("TYT-AYT Matematik Soruları");
	}

}
