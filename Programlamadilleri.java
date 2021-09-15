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

	// create jFrame with radioButton and JButton
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
		//radioButton[0].setBounds(50, 80, 200, 20);
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

	// handle all actions based on event
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
			label.setText("SORU 1");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 1) {
			label.setText("SORU 2");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 2) {
			label.setText("SORU 3");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 3) {
			label.setText("SORU 4");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 4) {
			label.setText("SORU 5");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 5) {
			label.setText("SORU 6");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 6) {
			label.setText("SORU 7");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 7) {
			label.setText("SORU 8");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 8) {
			label.setText("SORU 9");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		if (current == 9) {
			label.setText("SORU 10");
			radioButton[0].setText("A ŞIKKI");
			radioButton[1].setText("B ŞIKKI");
			radioButton[2].setText("C ŞIKKI");
			radioButton[3].setText("D ŞIKKI");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new programlamadilleri("TYT-AYT Matematik Soruları");
	}

}
