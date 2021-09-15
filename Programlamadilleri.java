package Programlamadilleri;
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
			label.setText("5) x/y,x-y,x sayıları küçükten büyüğe doğru sıralanmış\n" +"ardışık üç çift tam sayıdır. Buna göre x+y toplamı kaçtır ?");
			radioButton[0].setText("8");
			radioButton[1].setText("10");
			radioButton[2].setText("12");
			radioButton[3].setText("14");
		}
		if (current == 5) {
			label.setText("6) a ve b birbirinden farklı pozitif tam sayılar olmak üzere EKOK(a,b)\n" +"bir asal sayıya eşittir.\n" +"Buna göre,\n" +"1.    a ve b aralarında asal sayılardır.\n" +" + b toplamı bir tek sayıdır.\n" +"3.    a.b çarpımı bir tek sayıdır.\n" +"İfadelerinden hangileri her zaman doğrudur?");
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
                if (current == 10) {
			label.setText("Üç basamaklı ADB,ADC,DAA,DAD doğal sayıları\n" +
"            ADB<DAA\n" +
"            DAD<ADC\n" +
"eşitsizliklerini sağlamaktadır.\n" +
"Buna göre,aşağıdaki sıralamardan hangisi doğrudur? (D) ");
			radioButton[0].setText("A=D<B<C");
			radioButton[1].setText("C<A=B<D");
			radioButton[2].setText("D<A=B<C");
			radioButton[3].setText("B<A=D<C");
                        
                        
                        
		}
                      if (current == 11) {
			label.setText("Sıfırdan farklı x ve y gerçel sayıları için y<x ve x^2<y^2 olduğuna göre,\n" +
"1. x.y>0\n" +
"2. x+y<0\n" +
"3.  1/x-1/y>0\n" +
"ifadelerinden hangileri her zaman doğrudur? (B) ");
			radioButton[0].setText("Yalnız 2");
			radioButton[1].setText("1 ve 2");
			radioButton[2].setText("1 ve 3");
			radioButton[3].setText("2 ve 3");
                        
                        
                        
		}
                  if (current == 12) {
			label.setText("A kümesi,{1,2,3,4,5,6,7}kümesinin bir alt kümesi olmak üzere,\n" +
"        A ∩ {5,6,7} \n" +
"kümesinin elemanları tek sayılardır.\n" +
"Buna göre,bu koşulu sağlayan üç elemanlı kaç tane A kümesi vardır? (C) ");
			radioButton[0].setText("12");
			radioButton[1].setText("14");
			radioButton[2].setText("16");
			radioButton[3].setText("18");
                        
                        
                        
		}
                 if (current == 13) {
			label.setText("A,B ve C kümeleri\n" +
"A={(x,x):x ∈ R}\n" +
"B={x,3-x):x ∈ R}\n" +
"C={(x,x+4):x ∈ R}\n" +
"şeklinde tanımlanıyor.\n" +
"(p,q) ∈ A ∩ B ve (r,s) ∈ B ∩ C olduğuna göre,\n" +
"(p-r)/(q+s) ifadesinin değeri kaçtır? (d) ");
			radioButton[0].setText("1/4");
			radioButton[1].setText("3/4");
			radioButton[2].setText("4/5");
			radioButton[3].setText("2/5");
                        
                        
                        
		} if (current == 14) {
			label.setText("Geçel sayılar kümesi üzerinde f ve g fonksiyonları\n" +
"    f(x)=(x.(x-2))/2\n" +
"    g(x)=(x.(x-1).(x-2))/3\n" +
"biçiminde tanımlanıyor.\n" +
"    f(2x)=g(x+1)                                                                       \n" +
"eşitliğini sağlayan x değerlerinin toplamı kaçtır? (d) ");
			radioButton[0].setText("1");
			radioButton[1].setText("3");
			radioButton[2].setText("4");
			radioButton[3].setText("6");
                        
                        
                        
		} if (current == 15) {
			label.setText("Gerçel sayılar kümesi üzerinde bir f fonksiyonu, her x\n" +
"gerçel sayısı için n tam sayı olmak üzere,\n" +
"f(x)=x-n, x ∈ [n,n+1)\n" +
"biçiminde tanımlanıyor.\n" +
"Buna göre,\n" +
"f(1)+f(7/3)+f(13/6)\n" +
"toplamı kaçtır?( a) ");
			radioButton[0].setText("1/2");
			radioButton[1].setText("2/3");
			radioButton[2].setText("7/6");
			radioButton[3].setText("1");
                        
                        
                        
		}if (current == 16) {
			label.setText("Gerçel sayılar kümesi üzerinde bir f fonksiyonu\n" +
"f(x) = |x|/1+|x|\n" +
"biçiminde tanımlanıyor.\n" +
"Buna göre,[-2,1) aralığının f fonksiyonu\n" +
"altındaki görüntü kümesi aşağıdakilerden\n" +
"hangisidir? (D) ");
			radioButton[0].setText("[0,1]");
			radioButton[1].setText("(1/3,2/3]");
			radioButton[2].setText("[1/3,2/3)");
			radioButton[3].setText("[0,2/3]");
                        
                        
                        
		}if (current == 17) {
			label.setText("a ve b doğal sayılar olmak üzere,\n" +
"4.a ≡ 2(mod 11)\n" +
"4.b ≡ 5(mod 7)\n" +
"denklikleri veriliyor.\n" +
"Buna göre a+b toplamının alabileceği en küçük değer kaçtır?(B) ");
			radioButton[0].setText("7");
			radioButton[1].setText("9");
			radioButton[2].setText("11");
			radioButton[3].setText("13");
                        
                        
                        
		}if (current == 18) {
			label.setText("Pelin'in hesaap makinesi,\"3\"tuşuna her basıldığında bunu \n" +
" 1/6 olasılıkla 3\n" +
" 1/3 olasılıkla 4\n" +
" 1/2 olasılıkla 6\n" +
"olarak algılanmaktadır.\n" +
"Pelin sadece \"3\" numaraları tuşu bozuk olan bu hesap makinesiyle\n" +
" 23-(12/3)\n" +
"işlemini yapacaktır.\n" +
"Buna göre,Pelin'in bu işlemin sonucu 22 bulma olasılığı kaçtır?(B) ");
			radioButton[0].setText("1/3");
			radioButton[1].setText("1/4");
			radioButton[2].setText("1/9");
			radioButton[3].setText("5/12");
                        
                        
                        
		}if (current == 19) {
			label.setText("İki gerçel kökü olan x^2-ax+1=0 denkleminin\n" +
"kökleri toplamı\n" +
"x^2+6x+a=0\n" +
"denkleminin bir köküdür.\n" +
" Buna göre, a kaçtır ?(D) ");
			radioButton[0].setText("-4");
			radioButton[1].setText("-5");
			radioButton[2].setText("-6");
			radioButton[3].setText("-7");
                        
                        
                        
		}if (current == 20) {
			label.setText("(1-i^2).(1-i^6).(1-i^10) / (1-i).(1-i^3).(1-i^5)\n" +
"işleminin sonucu kaçtır?(D) ");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("2+i");
			radioButton[3].setText("2+2i");
                        
                        
                        
		}if (current == 21) {
			label.setText("4z-3z= 1-18i/2-i eşitliğini sağlayan z karmaşık sayısı \n" +
"aşağıdakilerden hangisidir? (D) ");
			radioButton[0].setText("-2+i");
			radioButton[1].setText("-3+i");
			radioButton[2].setText("4+2i");
			radioButton[3].setText("3-2i");
                        
                        
                        
		}if (current == 22) {
			label.setText("(x-1)^2 <|x-1|+6\n" +
"eşitsizliğini sağlayan x tam sayılarının toplamı kaçtır? (D) ");
			radioButton[0].setText("2");
			radioButton[1].setText("3");
			radioButton[2].setText("4");
			radioButton[3].setText("5");
                        
                        
                        
		}if (current == 23) {
			label.setText("(6x+1) / (x+1)^2 >1\n" +
"eşitsizliğini sağlayan tüm gerçel sayıların kümesi\n" +
"aşağıdakilerden hangisidir? (c) ");
			radioButton[0].setText("(-1,4)");
			radioButton[1].setText("(-1,6)");
			radioButton[2].setText("(0,4)");
			radioButton[3].setText("(0,∞)");
                        
                        
                        
		}if (current == 24) {
			label.setText("Üçüncü dereceden gerçel katsayılı polinomunun\n" +
"kökleri -3,-1 ve 2’dir.\n" +
"P(0)=12 olduğuna göre, x^2 li terimin katsayısı\n" +
"kaçtır? (a) ");
			radioButton[0].setText("-4");
			radioButton[1].setText("-3");
			radioButton[2].setText("-2");
			radioButton[3].setText("1");
                        
                        
                        
		}if (current == 25) {
			label.setText("a ve b tam sayılar olmak üzere \n" +
"P(x)=x^3-ax^2-(b+2)x+4b\n" +
"Q(x)=x^2-2ax+b\n" +
"polinomları için\n" +
"   P(-4)= 0\n" +
"   Q(-4)≠ 0\n" +
"olduğu biliniyor.\n" +
"Q(x) polinomunun kökleri aynı zamanda P(x)\n" +
"polinomunun da kökleri olduğuna göre, farkı\n" +
"kaçtır?(c) ");
			radioButton[0].setText("8");
			radioButton[1].setText("9");
			radioButton[2].setText("11");
			radioButton[3].setText("13");
                        
                        
                        
		}if (current == 25) {
			label.setText("Katsayıları {0,1,2,......,9} kümesinin elemanlarından\n" +
"ve bir kökü  -2/3 olan ikinci dereceden polinomların\n" +
"sayısı kaçtır?(b) ");
			radioButton[0].setText("5");
			radioButton[1].setText("7");
			radioButton[2].setText("8");
			radioButton[3].setText("10");
                        
                        
                        
		}if (current == 26) {
			label.setText("p, q ve r önermeleri için\n" +
"    (p=>q)=>r\n" +
"önermesinin yanlış olduğu biliniyor.\n" +
" Buna göre,\n" +
"I. p=>q\n" +
"II.q=>r\n" +
"III.r=>p\n" +
"önermelerinden hangileri her zaman doğrudur?(d) ");
			radioButton[0].setText("Yalnız 1");
			radioButton[1].setText("Yalnız 2 ");
			radioButton[2].setText("Yalnız 3");
			radioButton[3].setText("1 ve 3");
                        
                        
                        
		}if (current == 27) {
			label.setText("Bir öğrenci, doğru olduğunu düşündüğü aşağıdaki\n" +
"iddiayı ispatlarken bir hata yapmıştır.\n" +
"İddia : π sayısı e sayısına eşittir.\n" +
"Öğrencinin ispatı :x>0 için f(x) ve g(x) fonksiyonları \n" +
"f(x)=ln(πx) ve g(x)=ln(ex) olarak tanımlansın.\n" +
"1. Her x>0 için f(x) ve g(x) fonksiyonlarının\n" +
"türevleri birbirine eşittir.\n" +
"2. Dolayısıyla her x>0 için f(x) ve g(x)\n" +
"fonksiyonları birbirine eşittir.\n" +
"3. ln(x) fonksiyonu bire bir ve f(x)=g(x)\n" +
"olduğundan her  x>0 için πx=ex olduğu\n" +
"sonucuna varılır.\n" +
"4. Eğer iki fonksiyon her x>0 için birbirine eşitse,\n" +
"bu fonksiyonların x=1’deki değerleri aynıdır.\n" +
"V. πx ve ex fonksiyonlarının x=1’deki değerleri\n" +
"aynı olduğu için π=e olduğu sonucuna varılır.\n" +
" Bu öğrenci, numaralandırılmış adımların hangisinde\n" +
"hata yapmıştır?(b) ");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("3");
			radioButton[3].setText("4");
                        
                        
                        
		}if (current == 28) {
			label.setText("x^ln4 - 6.2^lnx +8 = 0\n" +
"denklemini sağlayan x değerlerinin çarpımı kaçtır?(c) ");
			radioButton[0].setText("e^6");
			radioButton[1].setText("e^4");
			radioButton[2].setText("e^3");
			radioButton[3].setText("e^2/2");
                        
                        
                        
		}if (current == 29) {
			label.setText("log3√27+log27√3 / log3√27-log27√3\n" +
"işleminin sonucu kaçtır?(c) ");
			radioButton[0].setText("3/2");
			radioButton[1].setText("4/3");
			radioButton[2].setText("5/4");
			radioButton[3].setText("6/5");
                        
                        
                        
		}if (current == 30) {
			label.setText("lnx+lny=9\n" +
"    lnx-lny=3\n" +
"olduğuna göre,logyX değeri kaçtır?(b) ");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("3");
			radioButton[3].setText("4");
                        
                        
                        
		}if (current == 31) {
			label.setText("(an)bir aritmetik dizi olmak üzere,\n" +
"   a10+a7=6\n" +
"   a9-a6=1\n" +
"eşitlikleri veriliyor.\n" +
"Buna göre,a1 kaçtır?(d) ");
			radioButton[0].setText("7/3");
			radioButton[1].setText("5/2");
			radioButton[2].setText("4/3");
			radioButton[3].setText("1/2");
                        
                        
                        
		}if (current == 32) {
			label.setText("(n pozitif bir tam sayı olmak üzere,\n" +
"        n\n" +
"        ∑ (-1)^k+1(k)=10\n" +
"        k=1\n" +
"eşitliği veriliyor.\n" +
"Buna göre, n kaçtır?(b) ");
			radioButton[0].setText("18");
			radioButton[1].setText("19");
			radioButton[2].setText("20");
			radioButton[3].setText("21");
                        
                        
                        
		}if (current == 33) {
			label.setText("(lim    x^2.sin(π-x)+π^2.sin(x-π) / (x-π)^2\n" +
"   x-->π\n" +
"limitinin değeri kaçtır?(a) ");
			radioButton[0].setText("-2π");
			radioButton[1].setText("-π");
			radioButton[2].setText("π");
			radioButton[3].setText("2π");
                        
                        
                        
		}if (current == 34) {
			label.setText("Gerçel sayılar kümesinde tanımlı f fonksiyonu her x için\n" +
"1≤f(x)≤2\n" +
"eşitsizliklerini sağlıyor.\n" +
" Buna göre,\n" +
"1.lim    1/f(x) vardır.\n" +
"   x-->1 \n" +
"2.lim    f(x)/x vardır.\n" +
"   x-->1\n" +
"3.lim    (|f(x)|-f(x)) vardır.\n" +
"   x-->1 \n" +
"ifadelerinden hangileri her zaman doğrudur?(c) ");
			radioButton[0].setText("Yalnız 1");
			radioButton[1].setText("Yalnız 2");
			radioButton[2].setText("Yalnız 3");
			radioButton[3].setText("Yalnız 4");
                        
                        
                        
		}if (current == 35) {
			label.setText("f(x)=√(x+√x) fonksiyonu için f'(1) değeri kaçtır?(a) ");
			radioButton[0].setText("3/4√2");
			radioButton[1].setText("1/2√2");
			radioButton[2].setText("1/√2");
			radioButton[3].setText("3/√2");
                        
                        
                        
		}if (current == 36) {
			label.setText("Gerçel sayılar kümesi üzerinde tanımlı \n" +
"    f(x)=sin(x/2)\n" +
"fonksiyonu için (f o f)'(2π) değeri kaçtır?(b) ");
			radioButton[0].setText("-1/2");
			radioButton[1].setText("-1/4");
			radioButton[2].setText("1/4");
			radioButton[3].setText("1/2");
                        
                        
                        
		}if (current == 37) {
			label.setText("Bir ayrıtı x birim uzunluğunda olan küp şeklindeki bir\n" +
"kristalin üretim maliyeti hacim üzerinden birimküp\n" +
"başına 5 TL, satış fiyatı ise yüzey alanı üzerinden\n" +
"birimkare başına 20 TL olarak hesaplanmaktadır.\n" +
" Buna göre, x kaç birim olursa bu kristalin\n" +
"satışından elde edilen kâr en fazla olur?(a) ");
			radioButton[0].setText("16");
			radioButton[1].setText("18");
			radioButton[2].setText("20");
			radioButton[3].setText("22");
                        
                        
                        
		}if (current == 38) {
			label.setText("a ve b gerçel sayılar olmak üzere,\n" +
"  f(x)=a.lnx+b.x^2+3\n" +
"fonksiyonunun grafiğine(1,f(1)) noktasında çizilen\n" +
"teğet doğrusunun denklemi y-2x+1 olarak\n" +
"veriliyor.\n" +
" Buna göre, a.b çarpımı kaçtır?(c) ");
			radioButton[0].setText("-18");
			radioButton[1].setText("-16");
			radioButton[2].setText("-12");
			radioButton[3].setText("-8");
                        
                        
                        
		}if (current == 38) {
			label.setText("a bir gerçel sayı olmak üzere,\n" +
"    f(x)=ln(2x+8)\n" +
"fonksiyonunun düşey asimptotu\n" +
"    g(x)=sinx/x^2+ax\n" +
"fonksiyonunun da düşey asimptotudur.\n" +
"Buna göre,a kaçtır?    (d) ");
			radioButton[0].setText("1");
			radioButton[1].setText("2");
			radioButton[2].setText("3");
			radioButton[3].setText("4");
                        
                        
                        
		}if (current == 39) {
			label.setText("0<x<π/2 olmak üzere,\n" +
" sec(x)-1/2 = 3/sec(x)+1\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre,tan(x)değeri kaçtır?    (d) ");
			radioButton[0].setText("√2");
			radioButton[1].setText("√3");
			radioButton[2].setText("√5");
			radioButton[3].setText("√6");
                        
                        
                        
		}if (current == 40) {
			label.setText("0<x<π/2 olmak üzere,\n" +
" sec(x)-1/2 = 3/sec(x)+1\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre,tan(x)değeri kaçtır?    (c) ");
			radioButton[0].setText("3");
			radioButton[1].setText("6");
			radioButton[2].setText("8");
			radioButton[3].setText("11");
                        
                        
                        
		}if (current == 41) {
			label.setText("Her x gerçel sayısı için A sayısı \n" +
"    4\n" +
"    ∑ cos(2kx)=A\n" +
"    k=2\n" +
"şeklinde tanımlanıyor.\n" +
"Buna göre, \n" +
"    4\n" +
"    ∑cos^2(kx)\n" +
"    k=2\n" +
"ifadesinin A türünden eşiti nedir?     (d) ");
			radioButton[0].setText("A+2");
			radioButton[1].setText("A+4");
			radioButton[2].setText("A+1/2");
			radioButton[3].setText("A+3/2");
                        
                        
                        
		}if (current == 42) {
			label.setText("Dik koordinat düzleminde orjinden geçen d1,d2\n" +
"doğruları ile x+y=6 doğrusunun sınırladığı kapalı bölge\n" +
"bir eşkenar üçgendir.\n" +
"Buna göre, bu eşkenar üçgenin alanı kaç birimkaredir?    (c) ");
			radioButton[0].setText("3√3");
			radioButton[1].setText("4√3");
			radioButton[2].setText("6√3");
			radioButton[3].setText("8√3");
                        
                        
                        
		}if (current == 43) {
			label.setText("Dik koordinat düzleminde (0,10) noktasından geçen bir\n" +
"çember x-eksenine (20,0) noktasında teğettir.\n" +
" Buna göre, bu çemberin yarıçapı kaç birimdir?  (d) ");
			radioButton[0].setText("18");
			radioButton[1].setText("20");
			radioButton[2].setText("21");
			radioButton[3].setText("25");
                        
                        
                        
		}if (current == 44) {
			label.setText("p pozitif bir gerçel sayı olmak üzere,\n" +
"     ( x^2 /(p+1)^2 )+ ( y^2 / (p-1)^2 ) =1\n" +
"denklemiyle verilen elipsin odak nokaları arasındaki uzaklık 12 birimdir.\n" +
"Buna göre,bu elipsin asal eksen uzunluğu kaç birimdir? (d) ");
			radioButton[0].setText("14");
			radioButton[1].setText("15");
			radioButton[2].setText("18");
			radioButton[3].setText("20");
                        
                        
                        
		}if (current == 45) {
			label.setText("Düzlemde sıfırdan farklı u ve v vektörlerinin toplamı sıfır\n" +
"vektörüne eşit olduğuna göre,                                                    \n" +
"1. ||2u-v||=||v||\n" +
"2.  u+3v =(2,-4)ise u=(-1,2)'dir.\n" +
"3.  u ile v arasındaki açı 180 derecedir.\n" +
"ifadelerinden hangileri doğrudur? (d) ");
			radioButton[0].setText("Yalnız 3");
			radioButton[1].setText("1 ve 2");
			radioButton[2].setText("1 ve 3");
			radioButton[3].setText("2 ve 3");
                        
                        
                        
		}if (current == 46) {
			label.setText(" Uzayda,\n" +
"     d1:x+1=y+2=z/2\n" +
"     d2:x/a=y/b=z-c/a\n" +
"doğruları dik kesişmektedir.\n" +
"Buna göre, c kaçtır?(a) ");
			radioButton[0].setText("9/4");
			radioButton[1].setText("7/3");
			radioButton[2].setText("5/2");
			radioButton[3].setText("3/4");
                        
                        
                        
		}if (current == 47) {
			label.setText(" Ua ve b gerçel sayılar olmak üzere,uzayda(1,1,1)\n" +
"noktasından geçen ax+(a+b)y+(a-b)z=6                                           \n" +
"düzlemi, x+2y-8z=5 düzlemine diktir.\n" +
"Buna göre,a+b toplamı kaçtır?(a) ");
			radioButton[0].setText("3");
			radioButton[1].setText("4");
			radioButton[2].setText("4");
			radioButton[3].setText("6");
                        
                        
                        
		}if (current == 48) { //ayt 2018 soruları başlangıç//
			label.setText(" a bir gerçel sayı olmak üzere, karmaşık sayılarda\n" +
"(1-ai)/a-i=i\n" +
"eşitliği veriliyor.\n" +
"Buna göre,a kaçtır?(d) ");
			radioButton[0].setText("3");
			radioButton[1].setText("2");
			radioButton[2].setText("1");
			radioButton[3].setText("0");
                        
                        
                        
		}if (current == 49) { 
			label.setText(" x, y ve z birbirinden farklı birer asal sayı olmak üzere,\n" +
"x(z-y)=18\n" +
"y(z-x)=40\n" +
"eşitlikleri veriliyor.\n" +
" Buna göre,x+y+z toplamı kaçtır?  (b) ");
			radioButton[0].setText("17");
			radioButton[1].setText("19");
			radioButton[2].setText("21");
			radioButton[3].setText("23");
                        
                        
                        
		}if (current == 50) { 
			label.setText("Dairesel bir oyun alanında konumları şekilde gösterilen\n" +
"Ali, Büşra, Cem, Deniz ve Ekin isimli beş oyuncu bir\n" +
"topla oyun oynamaktadır. Bu oyunun her seferinde;\n" +
"elinde top bulunan oyuncu, ok yönünde kendinden\n" +
"sonraki üçüncü oyuncuya topu vermektedir.\n" +
"\n" +
"               ALİ\n" +
"\n" +
"          EKİN     BÜŞRA\n" +
"              \n" +
"            DENİZ  CEM\n" +
"Başlangıçta top Ali'nin elinde bulunmaktadır ve Ali'nin\n" +
"topu Deniz'e vermesiyle oyun başlamıştır.\n" +
"Topu 1. seferde Deniz, 2. seferde Büşra almış ve oyun\n" +
"bu şekilde devam etmiştir.\n" +
"Buna göre, 99. seferde topu kim almıştır?  (c) ");
			radioButton[0].setText("Ali");
			radioButton[1].setText("Büşra");
			radioButton[2].setText("Cem");
			radioButton[3].setText("Deniz");
                        
                        
                        
		}if (current == 51) { 
			label.setText(" a, b ve c sıfırdan farklı birer gerçel sayı olmak üzere,\n" +
"    p:a+b=0\n" +
"    q:a+c<0\n" +
"    r:c<0\n" +
"önermeleri veriliyor.\n" +
"    (p ^ q)=>r\n" +
"önermesi yanlış olduğuna göre; a, b ve c sayılarının\n" +
"işaretleri sırasıyla aşağıdakilerden hangisidir?  (a) ");
			radioButton[0].setText("-,+,+");
			radioButton[1].setText("-,+,-");
			radioButton[2].setText("-,-,+");
			radioButton[3].setText("+,-,+");
                        
                        
                        
		}if (current == 52) { 
			label.setText(" a ve b tam sayılar olmak üzere, gösterimi, \n" +
"a sayısının b sayısını tam böldüğünü ifade eder.\n" +
"Bir öğrenci,\n" +
"“a, b ve c tam sayıları ve koşullarını\n" +
"sağlıyorsa koşulunu da sağlar.”\n" +
" önermesinin yanlış olduğunu aksine örnek verme\n" +
"yöntemini kullanarak ispatlamak istiyor.\n" +
"Buna göre, öğrencinin verdiği örnek aşağıdakilerden\n" +
"hangisi olabilir?  (d) ");
			radioButton[0].setText("1,3,12");
			radioButton[1].setText("2,4,24");
			radioButton[2].setText("3,2,30");
			radioButton[3].setText("4,5,60");
                        
                        
                        
		}if (current == 53) { 
			label.setText(" a ve b sıfırdan farklı gerçel sayılar olmak üzere, \n" +
"gerçel sayılar kümesi üzerinde tanımlı bir f fonksiyonu\n" +
"     f(ax+b)=x\n" +
"     f(a)=b/a\n" +
"eşitliklerini sağlamaktadır.\n" +
"Buna göre,f(0) değeri kaçtır?  (a) ");
			radioButton[0].setText("-1/2");
			radioButton[1].setText("-1/3");
			radioButton[2].setText("-2/3");
			radioButton[3].setText("1");
                        
                        
                        
		}if (current == 54) { 
			label.setText(" Gerçel katsayılı ve baş katsayısı 1 olan 4. dereceden \n" +
"bir P(x) polinomu her x gerçel sayısı için \n" +
"   P(x)=P(-x)\n" +
"eşitliğini sağlamaktadır." +
"   P(2)=P(3)=0\n" +
"olduğuna göre, P(1) kaçtır?  (c) ");
			radioButton[0].setText("12");
			radioButton[1].setText("18");
			radioButton[2].setText("24");
			radioButton[3].setText("30");
                        
                        
                        
		}if (current == 55) { 
			label.setText(" log₄x ve log₈1/x sayılarının aritmetik ortalaması\n" +
"1/2'dir.\n" +
"Buna göre , log₁₆x ifadesinin değeri kaçtır?  (b) ");
			radioButton[0].setText("1/2");
			radioButton[1].setText("3/2");
			radioButton[2].setText("5/2");
			radioButton[3].setText("1/4");
                        
                        
                        
		}if (current == 56) { 
			label.setText(" Terimleri birbirinden farklı ve ortak farkı r olan bir \n" +
"(an) aritmetik dizisi için\n" +
"    a₁=3.r\n" +
"    a₆=a₂.a₄\n" +
"eşitlikleri veriliyor.\n" +
" Buna göre, a₁₀ kaçtır?  (d) ");
			radioButton[0].setText("10");
			radioButton[1].setText("8");
			radioButton[2].setText("6");
			radioButton[3].setText("4");
                        
                        
                        
		}if (current == 57) { 
			label.setText(" a ve b pozitif gerçel sayılar olmak üzere,dik koordinat\n" +
"düzleminde orjinden geçen\n" +
"    p(x)=(x-a)^2-b\n" +
"parabolü kullanılarak\n" +
"    p(x+a)+b\n" +
"    p(x+a)-b\n" +
"    p(x-a)-b\n" +
"biçiminde tanımlanan üç parabolün tepe noktaları,\n" +
"alanı 16 birimkare olan bir üçgenin köşe noktalarıdır.\n" +
"Buna göre,a+b toplamı kaçtır?  (a) ");
			radioButton[0].setText("6");
			radioButton[1].setText("9");
			radioButton[2].setText("12");
			radioButton[3].setText("15");
                        
                        
                        
		}if (current == 58) { 
			label.setText(" m ve n sıfırdan ve birbirinden farklı iki gerçel sayı olmak\n" +
"üzere,\n" +
"   x^2+(m+1)x+n-m=0\n" +
"denkleminin köklerinden biri m-n sayısıdır.\n" +
"Buna göre,n/m oranı kaçtır?  (a) ");
			radioButton[0].setText("2");
			radioButton[1].setText("3");
			radioButton[2].setText("4");
			radioButton[3].setText("5");
                        
                        
                        
		}if (current == 59) { 
			label.setText("Bir sözcükte harflerin soldan sağa sıralanışıyla \n" +
"sağdan sola sıralanışı aynıysa bu sözcüğe bir \n" +
"palindrom sözcük denir.\n" +
"Örneğin; NEDEN, bir palindrom sözcüktür.\n" +
"Engin, birbirinden farklı 3 sesli ve 4 sessiz harfin her\n" +
"birini istediği sayıda kullanarak 5 harfli bir palindrom\n" +
"sözcük oluşturacaktır. Bu sözcükte iki sesli harfin yan\n" +
"yana gelmemesi ve iki sessiz harfin de yan yana\n" +
"gelmemesi gerekmektedir.\n" +
"Buna göre, Engin bu koşulları sağlayan kaç farklı\n" +
"palindrom sözcük oluşturabilir?         (b) ");
			radioButton[0].setText("72");
			radioButton[1].setText("84");
			radioButton[2].setText("108");
			radioButton[3].setText("120");
                        
                        
                        
		}if (current == 60) { 
			label.setText("L bir gerçel sayı olmak üzer, gerçel sayılar kümesi\n" +
"üzerinde tanımlı f ve g fonksiyonları için\n" +
"lim f(x)=lim g(x)=L\n" +
" x->2     x->2\n" +
"Buna göre,\n" +
"1. f(2)=g(2)\n" +
"2. lim f(x)-g(x)=0\n" +
"    x->2\n" +
"3. lim f(x)/g(x)=1\n" +
"    x->2\n" +
"ifadelerinden hangileri her zaman doğrudur?        (b) ");
			radioButton[0].setText("Yalnız 1");
			radioButton[1].setText("Yalnız 2");
			radioButton[2].setText("1 ve 3");
			radioButton[3].setText("2 ve 3");
                        
                        
                        
		}if (current == 61) { 
			label.setText("| 10-x^2     ,   x<0     \n" +
"       |\n" +
"       | ax+b       ,   0≤x≤3\n" +
"f(x)=  |\n" +
"       | (1-x)^2    ,   x>3\n" +
"fonksiyonu gerçel sayılar kümesi üzerinde süreklidir.\n" +
"Buna göre,a+b toplamı kaçtır?                                   \n     (a) ");
			radioButton[0].setText("16");
			radioButton[1].setText("15");
			radioButton[2].setText("12");
			radioButton[3].setText("8");
                        
                        
                        
		}if (current == 62) { 
			label.setText("f(x)=e^x.cosx fonksiyonunun 16.mertebeden türevi\n" +
"olan f^(16)(x) ifadesinin x=0 noktasındaki değeri kaçtır?  (d) ");
			radioButton[0].setText("32");
			radioButton[1].setText("64");
			radioButton[2].setText("128");
			radioButton[3].setText("252");
                        
                        
                        
		}if (current == 63) { 
			label.setText("a, b ve c gerçel sayılar olmak üzere,\n" +
"    y=a/x+a\n" +
"eğrisine noktasında teğet olan doğrunun\n" +
"denklemi\n" +
"    y=(-x/8)+c\n" +
"biçiminde veriliyor.\n" +
"Buna göre,a+b+c toplamı kaçtır?  (c) ");
			radioButton[0].setText("7/4");
			radioButton[1].setText("11/4");
			radioButton[2].setText("13/4");
			radioButton[3].setText("2");
                        
                        
                        
		}if (current == 64) { 
			label.setText("Bir internet şirketi en fazla 1000 müşteriye hizmet\n" +
"verebilmekte ve aylık internet ücretini 40 TL olarak\n" +
"belirlediğinde bu sayıya ulaşabilmektedir. Bu şirket aylık\n" +
"internet ücretinde yaptığı her 5 TL’lik artış sonrasında\n" +
"müşteri sayısında 50 azalma olduğunu gözlemlemiştir.\n" +
" Bu şirket, aylık internet ücretinden elde edeceği\n" +
"toplam gelirin en fazla olması için aylık internet\n" +
"ücretini kaç TL olarak belirlemelidir?  (d) ");
			radioButton[0].setText("55");
			radioButton[1].setText("60");
			radioButton[2].setText("65");
			radioButton[3].setText("70");
                        
                        
                        
		}if (current == 65) { 
			label.setText("Gerçel sayılar kümesi üzerinde tanımlı, artan ve sürekli\n" +
"bir f fonksiyonu için \n" +
" f(0)=2\n" +
" f(1)=3\n" +
" f(2)=4                                                        ∫\n" +
"eşitlikleri verilmiştir.\n" +
"            2   \n" +
" Buna göre, ∫ f(x)dx integralinin değeri\n" +
"            0  \n" +
"aşağıdakilerden hangisi olabilir? (c) ");
			radioButton[0].setText("4");
			radioButton[1].setText("4,5");
			radioButton[2].setText("6");
			radioButton[3].setText("7,5");
                        
                        
                        
		}if (current == 66) { 
			label.setText("Bir matematik dersinde kısmi integrasyon konusunu\n" +
"işleyen Ebru Öğretmen tahtaya\n" +
"∫udv=uv-∫vdu\n" +
"kuralını yazdıktan sonra, Mehmet bir sorunun                 \n" +
"çözümünde u ve v yerine sırasıyla f(x) ve g(x)\n" +
"fonksiyonlarını seçip bu kuralı uygulayarak\n" +
"∫f(x)g'(x)dx=f(x)/x -∫2/x^2dx\n" +
"eşitliğini elde ediyor.\n" +
"f(1)=2 olduğuna göre, f(e) değeri kaçtır? (b) ");
			radioButton[0].setText("2");
			radioButton[1].setText("4");
			radioButton[2].setText("6");
			radioButton[3].setText("8");
                        
                        
                        
		}if (current == 67) { 
			label.setText("a ve b pozitif gerçel sayılar olmak üzere, dik koordinat\n" +
"düzleminde\n" +
"   y=ax^2+b\n" +
"eğrisi ile x=0 ,x=2 ve y=0 ve doğruları arasında\n" +
"kalan bölge, (2,0) ve (0,b) noktalarından geçen\n" +
"doğru ile alanları oranı 3 olan iki bölgeye ayrılıyor.\n" +
" Buna göre, a/b oranı kaçtır? (c) ");
			radioButton[0].setText("1/2");
			radioButton[1].setText("2/3");
			radioButton[2].setText("3/4");
			radioButton[3].setText("4/5");
                        
                        
                        
		}if (current == 68) { 
			label.setText("cot(34).sin(44) / sin(22).sin(56)\n" +
"ifadesinin eşiti aşağıdakilerden hangisidir?(d) ");
			radioButton[0].setText("2cot(22)");
			radioButton[1].setText("2cos(56)");
			radioButton[2].setText("4sin(44)");
			radioButton[3].setText("4cos(34)");
                        
                        
                        
		}if (current == 69) { 
			label.setText("0<x<π olmak üzere,\n" +
"   sinx.cosx/sinx+cosx = sinx-cosx/2 \n" +
"eşitliğini sağlayan x değerlerinin toplamı kaçtır?(b) ");
			radioButton[0].setText("π/2");
			radioButton[1].setText("5π/4");
			radioButton[2].setText("7π/4");
			radioButton[3].setText("π");
                        
                        
                        
		}if (current == 70) { 
			label.setText("Dik koordinat düzleminde; bir köşesi orijinde, diğer          \n" +
"köşeleri ise y=x ve y=-x doğruları üzerinde olan\n" +
"bir üçgenin kenarortayları (2,4) noktasında\n" +
"kesişmektedir.\n" +
" Buna göre, bu üçgenin alanı kaç birimkaredir?(c) ");
			radioButton[0].setText("18");
			radioButton[1].setText("24");
			radioButton[2].setText("27");
			radioButton[3].setText("9√2");
                        
                        
                        
		}if (current == 71) { 
			label.setText("Dik koordinat düzleminde birinin merkezi (12,0)\n" +
"noktası, diğerinin merkezi ise (0,9) noktası olan iki\n" +
"çember sadece (4,6) noktasında kesişmektedir.\n" +
" Bu çemberlerin orijine en yakın olan noktaları\n" +
"arasındaki uzaklık kaç birimdir?(d) ");
			radioButton[0].setText("√5");
			radioButton[1].setText("√10");
			radioButton[2].setText("√13");
			radioButton[3].setText("2√5");
                        
                        
                        
		}if (current == 72) { 
			label.setText("Dik koordinat düzleminde,u₁=(3,4) ve u₂=(8,-6)\n" +
"vektörleri veriliyor. Bu düzlemde alınan bir v                    \n" +
"vektörünün, u₁ vektörü üzerine dik izdüşüm vektörü \n" +
"3 birim, u₂ vektörü üzerine dik izdüşüm vektörü ise \n" +
"1 birim uzunluğundadır.\n" +
" Buna göre, v vektörünün uzunluğu kaç birimdir?   (b) ");
			radioButton[0].setText("√5");
			radioButton[1].setText("√10");
			radioButton[2].setText("5√5");
			radioButton[3].setText("5");
                        
                        
                        
		}if (current == 73) { 
			label.setText("Ayrıt uzunluğu 1 birim olan 3 adet küp, her birinin en az\n" +
"bir yüzü diğer bir küpün bir yüzüyle tam örtüşecek\n" +
"biçimde birbirine yapıştırılıyor.\n" +
"Buna göre, bu şekilde elde edilebilecek bir cismin\n" +
"seçilen iki köşesi arasındaki uzaklık birim türünden\n" +
"aşağıdakilerden hangisi olamaz?   (a) ");
			radioButton[0].setText("√7");
			radioButton[1].setText("√8");
			radioButton[2].setText("√9");
			radioButton[3].setText("√10");
                        
                        
                        
		}if (current == 74) { //2019 ayt 
			label.setText("Karmaşık sayılar kümesinde \n" +
"(4-2i).(6+3i)/(1-i).(1+i)\n" +
"işleminin sonucu kaçtır ?   (a) ");
			radioButton[0].setText("15");
			radioButton[1].setText("12");
			radioButton[2].setText("10");
			radioButton[3].setText("9");
                        
                        
                        
		}if (current == 75) { 
			label.setText("A,B ve C sıfırdan ve birbirinden farklı birer rakam\n" +
"olmak üzere,\n" +
" \n" +
"    ABC\n" +
"    CAB\n" +
"    BCA\n" +
"üç basamaklı doğal sayıları sırasıyla 4,5 ve 9 ile tam\n" +
"bölünmektedir.\n" +
"Buna göre, A.B.C çarpımı kaçtır ?  (d) ");
			radioButton[0].setText("150");
			radioButton[1].setText("180");
			radioButton[2].setText("200");
			radioButton[3].setText("210");
                        
                        
                        
		}if (current == 76) { 
			label.setText("123 sayısına sırasıyla aşağıdaki adımlar uygulanarak\n" +
"rakamlarının yerleri değiştiriliyor ve her adımda tekrar\n" +
"üç basamaklı bir sayı elde ediliyor.\n" +
"\n" +
"• 1. adımda, sayının onlar ve yüzler basamağındaki\n" +
"rakamların yerleri değiştirilerek bir sayı elde ediliyor.\n" +
"• 2. adımda, bir önceki adımda elde edilen sayının birler\n" +
"ve onlar basamağındaki rakamların yerleri değiştirilerek\n" +
"bir sayı elde ediliyor.\n" +
"\n" +
"Bu şekilde devam edilerek,adım numarası tek sayı ise\n" +
"bir önceki adımda elde edilen sayının onlar ve yüzler,\n" +
"adım numarası çift sayı ise bir önceki adımda elde edilen\n" +
"sayının birler ve onlar basamağındaki rakmaların yerleri\n" +
"değiştirilerek sayılar elde ediliyor.\n" +
"Buna göre,75. adım sonunda elde edilen sayı \n" +
"aşağıdakilerden hangisidir ?  (A) ");
			radioButton[0].setText("321");
			radioButton[1].setText("312");
			radioButton[2].setText("231");
			radioButton[3].setText("231");
                        
                        
                        
		}if (current == 77) { 
			label.setText("Bir masada;biri kırmızı, biri mavi ve biri sarı renkli\n" +
"olmak üzere toplam üç bilye bulunmaktadır.Bu bilyeler\n" +
"A,B ve C torbalarına her bir torbada bir bilye olacak\n" +
"şekilde konuluyor ve \n" +
"\n" +
"        p:\"A torbasında kırmızı bilye yoktur.\"\n" +
"        q:\"B torbasında mavi bilye vardır.\"\n" +
"        r:\"C torbasında sarı bilye yoktur.\"\n" +
"   önermeleri veriliyor.\n" +
"  p⋀(q⋁r)'\n" +
"\n" +
"önermesi doğru olduğuna göre; A,B ve C torbalarında\n" +
"bulunan bilyelerin renkleri sırasıyla aşağıdakilerden\n" +
"hangisidir ?  (b) ");
			radioButton[0].setText("Kırmızı-Mavi-Sarı");
			radioButton[1].setText("Mavi-Kırmızı-Sarı");
			radioButton[2].setText("Mavi-Sarı-Kırmızı");
			radioButton[3].setText("Sarı-Kırmızı-Mavi");
                        
                        
                        
		}if (current == 78) { 
			label.setText("Matematik dersinde,Canan sırasıyla aşağıdaki adımları\n" +
"takip ederek işlemler yapmıştır.\n" +
"\n" +
"I.adım     : 6=1.2.3=e^ln1.e^ln2.e^ln3\n" +
"II.adım    : e^ln1.e^ln2.e^ln3 = e^ln1+ln2+ln3\n" +
"III.adım   : e^ln1+ln2+ln3=e^ln6\n" +
"IV.adım    : e^ln6=e^ln(2+4)\n" +
"V.adım     : e^ln(2+4)=e^ln2+ln4\n" +
"VI.adım    : e^ln2+ln4=e^ln2.e^ln4\n" +
"VII.adım   : e^ln2.e^ln4=2.4=8\n" +
"Bu adımlar sonunda Canan, 6=8 sonucunu elde etmiştir.\n" +
"Buna göre,Canan numaraladırılmış adımların hangisinde \n" +
"hata yapmıştır?  (d) ");
			radioButton[0].setText("I");
			radioButton[1].setText("III");
			radioButton[2].setText("IV");
			radioButton[3].setText("V");
                        
                        
                        
		}if (current == 79) { 
			label.setText("Gerçel sayılar kümesi üzerinde tanımlı bir f fonksiyonu\n" +
"her x ve y gerçel sayısı için\n" +
"f(x+y)=f(x)+f(y) eşitliğini sağlamaktadır.\n" +
"f(2)-f(1)=10 olduğuna göre,\n" +
"f(3).f(4)/f(5)\n" +
"işleminin sonucu kaçtır? (D) ");
			radioButton[0].setText("16");
			radioButton[1].setText("18");
			radioButton[2].setText("21");
			radioButton[3].setText("24");
                        
                        
                        
		}if (current == 80) { 
			label.setText("a bir gerçel sayı olmak üzere,x+1≤a eşitliği ile\n" +
"ilgili aşağıdakiler bilinmektedir.\n" +
"• x=0 bu eşitsizliği sağlar.\n" +
"• x=4 bu eşitsizliği sağlamaz.\n" +
"Buna göre,a sayısının alabileceği değerleri ifade eden \n" +
"en geniş aralık aşağıdakilerden hangisidir ? (D) ");
			radioButton[0].setText("[0,4)");
			radioButton[1].setText("[1,4]");
			radioButton[2].setText("(1,5]");
			radioButton[3].setText("[1,5");
                        
                        
                        
		}if (current == 81) { 
			label.setText("Birbirinden farklı a,b ve c gerçel sayıları için\n" +
"a+b=|a|\n" +
"b+c=|b|\n" +
"eşitlikleri veriliyor.\n" +
"Buna göre;a,b ve c sayılarının doğru sıralanışı \n" +
"aşağıdakilerden hangisidir ?(B) ");
			radioButton[0].setText("a<b<c");
			radioButton[1].setText("a<c<b");
			radioButton[2].setText("b<a<c");
			radioButton[3].setText("b<c<a");
                        
                        
                        
		}if (current == 82) { 
			label.setText("En yüksek dereceli terimin katsayısı 1 olan ikinci\n" +
"dereceden gerçel katsayılı bir P(x) polinomunun iki \n" +
"farklı kökü P(0) P(-1) değerleridir.\n" +
"Buna göre, P(2) değeri kaçtır?(C) ");
			radioButton[0].setText("1/2");
			radioButton[1].setText("3/2");
			radioButton[2].setText("5/2");
			radioButton[3].setText("1");
                        
                        
                        
		}if (current == 83) { 
			label.setText("x sayısı, 1'den büyük bir tam sayı olmak üzere,\n" +
"\n" +
"• 64/x oranının bir tam sayı olduğu,\n" +
"• ln64/lnx oranının bir tam sayı olmadığı veriliyor.\n" +
"Buna göre, x'in alabileceği değerler toplamı kaçtır ?(C) ");
			radioButton[0].setText("40");
			radioButton[1].setText("42");
			radioButton[2].setText("48");
			radioButton[3].setText("54");
                        
                        
                        
		}if (current == 84) {
                label.setText("Ada,kullandığı bilimsel bir hesap makinesinde \n" +
"n⋜23 olmak üzere, her n pozitif tam sayı için log₂n\n" +
"değerini hesaplıyor ve her bir değerin tam sayı \n" +
"ya da ondalıklı sayı olduğunu görüyor.\n" +
"Ada;ekranda görünen değer tam sayı ise o sayıyı,\n" +
"ondalıklı sayı ise o sayının tam ksımını bir kağıda \n" +
"yazdıktan sonra yazdığı bu sayıların toplamını buluyor.\n" +
"Buna göre,Ada'nın bulduğu toplamın sonucu kaçtır ?(D) ");
                radioButton[0].setText("94");
                radioButton[1].setText("97");
                radioButton[2].setText("100");
                radioButton[3].setText("103");

            }if (current == 85) {
                label.setText("Herhangi ardışık 3 teriminin toplamı birbirine\n" +
"eşit olan bir An dizisi için\n" +
"\n" +
"a₂+a₃=a₄=2\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre,\n" +
"a₁+a₂+...+a₂₅\n" +
"toplamının sonucu kaçtır ?(A) ");
                radioButton[0].setText("34");
                radioButton[1].setText("35");
                radioButton[2].setText("36");
                radioButton[3].setText("37");

            }if (current == 86) {
                label.setText("A ve B rakamlardan oluşan boştan farklı birer küme\n" +
"olmak üzere,\n" +
"A⋂B= A⋂{0,2,4,6,8}\n" +
"eşitliği sağlanıyorsa A kümesine B kümesinin ortakesişim\n" +
"kümesi denir.\n" +
"A kümesi, \n" +
" b={0,1,2,3,4}\n" +
"kümesinin ortakesişim kümesi olduğuna göre, kaç farklı\n" +
"A kümesi vardır ?(D) ");
                radioButton[0].setText("7");
                radioButton[1].setText("15");
                radioButton[2].setText("31");
                radioButton[3].setText("63");

            }if (current == 87) {
                label.setText(" Ege'nin çantasında boyutları aynı olan kimlik kartı,\n" +
"öğrenci kartı,yemek kartı ve otobüs kartı olmak üzere\n" +
"dört kart bulunmaktadır.Ege,otboüs kartını bulmak için\n" +
"çantasından rastgele bir kart çıkartıyor.Yanlış kartı\n" +
"çıkartmışsa onu elinde tutarak çantasından rastgele\n" +
"bir kart daha çıkartıyor ve otobüs kartını bulana kadar\n" +
"bu şekilde devam ediyor.\n" +
"Ege'nin otobüs kartını üçüncü denemede bulma \n" +
"olasılığı kaçtır?(A) ");
                radioButton[0].setText("1/4");
                radioButton[1].setText("1/8");
                radioButton[2].setText("3/8");
                radioButton[3].setText("1/16");

            }if (current == 88) {
                label.setText("Gerçel sayılar kümesinin bir alt kümesi üzerinde \n" +
"bir f fonksiyonu \n" +
"f(x)=x^2-4x+4/x-2 + x^2-6x+9/2x-6\n" +
"biçiminde tanımlanıyor.\n" +
"Buna göre,\n" +
"lim f(x)x→2 + lim f(x)x→3 \n" +
"ifadesinin değeri kaçtır?(B) ");
                radioButton[0].setText("3/2");
                radioButton[1].setText("1/2");
                radioButton[2].setText("4/3");
                radioButton[3].setText("3/4");

            }if (current == 89) {
                label.setText("a bir gerçek sayı olmak üzere, gerçel sayılar kümesi\n" +
"üzerinde bir f fonksiyonu\n" +
"\n" +
"\n" +
"        ╭  a-x         ,     x<1\n" +
"        |  \n" +
" f(x)= ˂  5x-4        ,    1≤x≤5\n" +
"        | \n" +
"        ╰ (x-a)^2+12   ,     x>5\n" +
"\n" +
"biçiminde tanımlanıyor.\n" +
"f fonksiyonunun sürekli olmadığı yalnızca bir nokta \n" +
"olduğuna göre,\n" +
" f(7)-f(0)\n" +
"ifadesinin değeri kaçtır ?(C) ");
                radioButton[0].setText("3");
                radioButton[1].setText("4");
                radioButton[2].setText("5");
                radioButton[3].setText("6");

            }if (current == 90) {
                label.setText("k bir gerçek sayı olmak üzere, gerçel sayılar\n" +
"kümesinin birer alt kümesi üzerinde tanımlı ve \n" +
"türevlenebilir f ve g fonksiyonları için\n" +
"f(x)=g(x^2)+kx^3\n" +
"eşitliği sağlanmaktadır.\n" +
"f'(-1)=g'(1)=2\n" +
"olduğuna göre,k kaçtır? ?(A) ");
                radioButton[0].setText("2");
                radioButton[1].setText("1");
                radioButton[2].setText("0");
                radioButton[3].setText("-1");

            }if (current == 91) {
                label.setText("Gerçel sayılar kümesi üzerinde bir f fonksiyonu\n" +
"f(x)=x^2+x-4\n" +
"biçiminde tanımlanıyor.\n" +
"Gerçel sayılar kümesi üzerinde tanımlı ve sürekli bir\n" +
"g fonksiyonunun türevi olan g'fonksiyonu g'(x)=0\n" +
"eşitliğini yalnızca x=2 değeri için sağlamaktadır.\n" +
"Buna göre,\n" +
"(g ○ f)'(x)=0\n" +
"eşitliğini sağlayan x değerlerinin çarpımı kaçtır ?(C) ");
                radioButton[0].setText("0");
                radioButton[1].setText("1");
                radioButton[2].setText("3");
                radioButton[3].setText("4");

            }if (current == 92) {
                label.setText("Dik koordinat düzleminde,f(x)=x^2 + ax fonksiyonunun\n" +
"grafiğine (2,f(2)) noktasından çizilen teğet doğrusu,\n" +
"g(x)=bx^3 fonksiyonunun grafiğine (1,g(1)) noktasında\n" +
"teğettir.\n" +
"Buna göre,a.b çarpımı kaçtır? (B) ");
                radioButton[0].setText("2");
                radioButton[1].setText("4");
                radioButton[2].setText("6");
                radioButton[3].setText("8");

            }if (current == 93) {
                label.setText("a∈(π/12,π/6) olmak üzere\n" +
"x=sin(3a)\n" +
"y=cos(3a)\n" +
"z=tan(3a)\n" +
"sayılarının doğru sıralanışı aşağıdakilerden hangisidir? (C) ");
                radioButton[0].setText("x<y<z");
                radioButton[1].setText("x<z<y");
                radioButton[2].setText("y<x<z");
                radioButton[3].setText("y<z<x");

            }if (current == 94) {
                label.setText("0<x<π/2 olmak üzere\n" +
"secx.tanx.(1-sinx)=1/4\n" +
"olduğuna göre,cscx değeri kaçtır? (D) ");
                radioButton[0].setText("5/2");
                radioButton[1].setText("7/2");
                radioButton[2].setText("2");
                radioButton[3].setText("3");

            }if (current == 95) {
                label.setText("m bir gerçel sayı olmak üzere, dik koordinat düzleminde\n" +
"•(0,1) noktasından geçen bir doğrunun eğiminin m,\n" +
"•(0,0) noktasından geçen bir doğrunun eğiminin 2m,\n" +
"•(1,0) noktasından geçen bir doğrunun eğiminin 3m\n" +
"olduğu ve bu üç doğrunun bir noktada kesiştiği bilinmektedir.\n" +
"Buna göre, m değeri kaçtır? (B) ");
                radioButton[0].setText("1/2");
                radioButton[1].setText("1/3");
                radioButton[2].setText("3/4");
                radioButton[3].setText("3/5");

            }if (current == 96) {
                label.setText("Dik koordinat düzleminde,x+y=4 doğrusu ile\n" +
"iki eş parçaya ayrılan çember x-eksenini tek noktada,\n" +
"y-eksenini ise iki farklı noktada kesmektedir.\n" +
"Çemberin y-eksenini kestiği noktalar arasındaki \n" +
"uzaklık 4 birim olduğuna göre,çemberin çevresi \n" +
"kaç birimdir? (B) ");
                radioButton[0].setText("4π");
                radioButton[1].setText("5π");
                radioButton[2].setText("6π");
                radioButton[3].setText("7π");
                
                }if (current == 97) {
                label.setText("Düzlemde bir ABC dik üçgeninnin köşe noktalarını\n" +
"merkez kabul eden ve birbirini kesmeyen r yarıçaplı\n" +
"üç daire oluşturuluyor.Üçgenin kenarları üzerinde olup\n" +
"bu dairelerin içinde kalmayan parçaların uzunlukları\n" +
"2 birim, 3 birim ve 5 birim olarak veriliyor.\n" +
"Buna göre,dairelerin içinde olup üçgenin dışında kalan \n" +
"bölgelerin alanları toplamı kaç birimkaredir?(D) ");
                radioButton[0].setText("8π");
                radioButton[1].setText("9π");
                radioButton[2].setText("9π/2");
                radioButton[3].setText("15π/2");
                
                }if (current == 98) {
                label.setText("Dik koordinat düzleminde bir P(a,b) noktası orjin\n" +
"etrafında saat yönünün tersine 90° döndürüldükten \n" +
"sonra elde edilen nokta;x-ekseni boyunca pozitif yönde\n" +
"3 birim,y-ekseni boyunca pozitif yönde 1 birim\n" +
"ötelendiğinde yine P(a,b)noktası elde ediliyor.\n" +
"Buna göre,a.b çarpımı kaçtır? (C) ");
                radioButton[0].setText("0");
                radioButton[1].setText("1");
                radioButton[2].setText("2");
                radioButton[3].setText("3");
                
                }if (current == 99) { //2020 AYT //
                label.setText("Aşağıdaki kutuların içine 1’den 9’a kadar olan\n" +
"tam sayılardan 6 tanesi her kutuya farklı bir sayı gelecek\n" +
"şekilde yerleştirildiğinde tüm eşitlikler sağlanmaktadır.\n" +
"□+□=5\n" +
"□-□=5\n" +
"□﹕□=5\n" +
"Buna göre, kullanılmayan tam sayıların toplamı\n" +
"kaçtır? (B) ");
                radioButton[0].setText("23");
                radioButton[1].setText("21");
                radioButton[2].setText("19");
                radioButton[3].setText("17");
                
                }if (current == 100) { 
                label.setText("a, b ve c asal sayılar olmak üzere,\n" +
"a(a+b)=c(c-b)=143\n" +
"eşitlikleri veriliyor.\n" +
"Buna göre, a+b+c toplamı kaçtır?(B) ");
                radioButton[0].setText("22");
                radioButton[1].setText("26");
                radioButton[2].setText("30");
                radioButton[3].setText("32");
                
                }if (current == 101) { 
                label.setText("x ve y tam sayıları için\n" +
"9^x-3^2x-2=2^y.3^6\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre, x+y toplamı kaçtır?(D) ");
                radioButton[0].setText("4");
                radioButton[1].setText("5");
                radioButton[2].setText("6");
                radioButton[3].setText("7");
                
                }if (current == 102) { 
                label.setText("a, b ve c gerçel sayıları için\n" +
"a-b<0<c<c-b\n" +
"eşitsizliği veriliyor.\n" +
"Buna göre,\n" +
"I. a.b.c>a\n" +
"II.(a+c).b>a\n" +
"III.b-a+c>a\n" +
"ifadelerinden hangileri her zaman doğrudur?(D) ");
                radioButton[0].setText("Yalnız I");
                radioButton[1].setText("Yalnız II");
                radioButton[2].setText("I ve II");
                radioButton[3].setText("I ve III");
                
                }if (current == 103) { 
                label.setText(" x ve y tam sayılar olmak üzere,\n" +
"|x-3|+|2x+y|+|2x+y-1|=1\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre, y'nin alabileceği değerler toplamı kaçtır?(B) ");
                radioButton[0].setText("-12");
                radioButton[1].setText("-11");
                radioButton[2].setText("-10");
                radioButton[3].setText("-9");
                
                }if (current == 104) { 
                label.setText(" Üç basamaklı ABA doğal sayısının iki basamaklı A1 doğal sayısı ile bölümünden elde edilen bölüm 13, kalan ise 19 oluyor.\n" +
"Buna göre, A+B toplamı kaçtır?(D) ");
                radioButton[0].setText("8");
                radioButton[1].setText("9");
                radioButton[2].setText("10");
                radioButton[3].setText("11");
                
                }if (current == 105) { 
                label.setText(" A,B ve C kümeleriyle ilgili\n" +
"﹛(1,2),(2,3),(3,4﹜⊆AxB\n" +
"﹛(1,2),(3,4),(4,2),(4,4)﹜⊆AxB\n" +
"olduğu biliniyor.\n" +
"Buna göre,\n" +
"I. A⋂B kümesi en az 3 elemanlıdır.\n" +
"II. A⋂C kümesi en az 3 elemanlıdır.\n" +
"III. B⋂C kümesi en az 3 elemanlıdır.\n" +
"ifadelerinden hangileri her zaman doğrudur?(A) ");
                radioButton[0].setText("Yalnız I");
                radioButton[1].setText("Yalnız II");
                radioButton[2].setText("Yalnız III");
                radioButton[3].setText("I ve III");
                
                }if (current == 106) { 
                label.setText("Her elemanı bir pozitif tam sayı olan bir kümenin\n" +
"eleman sayısı, bu kümenin en küçük elemanının\n" +
"değerinden bir fazla ise bu kümeye geniş küme denir.\n" +
"A, B ve C geniş kümeler olmak üzere, \n" +
"•A⋃B⋃C=﹛1,2,3,4,5,6,7,8,9﹜\n" +
"•A⋂B=﹛3﹜\n" +
"•1∈A\n" +
"•6∈B\n" +
"olduğu biliniyor.\n" +
"Buna göre, C kümesi aşağıdakilerden hangisidir?(A) ");
                radioButton[0].setText("﹛1,2﹜");
                radioButton[1].setText("﹛3,4,8,9﹜");
                radioButton[2].setText("﹛3,5,7,8﹜");
                radioButton[3].setText("﹛4,5,6,7,8﹜");
                
                }if (current == 107) { 
                label.setText("Karmaşık sayılar kümesinde\n" +
"i.(2-i).(2-4i)/(1-i).(1+i)\n" +
"işleminin sonucu kaçtır?(b) ");
                radioButton[0].setText("2");
                radioButton[1].setText("5");
                radioButton[2].setText("10");
                radioButton[3].setText("2i");
                
                }if (current == 108) { 
                label.setText("a ve b sıfırdan farklı birer tam sayı olmak üzere, gerçel\n" +
"sayılar kümesi üzerinde bir f fonksiyonu\n" +
"f(x)=ax+b\n" +
"biçiminde tanımlanıyor.\n" +
"olduğuna göre, değeri kaçtır?(D) ");
                radioButton[0].setText("7");
                radioButton[1].setText("8");
                radioButton[2].setText("9");
                radioButton[3].setText("10");
                
                }if (current == 109) { 
                label.setText("P(x)ve Q(x)sabit olmayan birer polinom, R(x) ise birinci dereceden bir polinom olmak üzere,\n" +
"P(x)=Q(x).R(x)\n" +
"eşitliği sağlanmaktadır.\n" +
"Buna göre,\n" +
"I. P(x)ve polinomlarının sabit terimleri aynıdır.\n" +
"II. ’in grafiği bir parabol ise ’in grafiği bir\n" +
"doğrudur.\n" +
"III. polinomunun her kökü polinomunun da\n" +
"bir köküdür.\n" +
" ifadelerinden hangileri her zaman doğrudur?(D) ");
                radioButton[0].setText("Yalnız III");
                radioButton[1].setText("I ve II");
                radioButton[2].setText("I ve III");
                radioButton[3].setText("II ve III");
                
                }if (current == 110) { 
                label.setText("Her birinin en yüksek dereceli teriminin katsayısı 1 olan\n" +
"üçüncü dereceden gerçel katsayılı P(x) ve R(x)\n" +
"polinomları için 2 ve 6 ortak köklerdir. P(x)-R(x)\n" +
"polinomu ile bölündüğünde kalan 10 olmaktadır.\n" +
"Buna göre, P(0)-R(0) değeri kaçtır?(A) ");
                radioButton[0].setText("24");
                radioButton[1].setText("27");
                radioButton[2].setText("30");
                radioButton[3].setText("33");
                
                }if (current == 111) { 
                label.setText("m ve n tam sayılar olmak üzere,\n" +
"(x^2+2y)^7\n" +
"ifadesinin açılımında terimlerden biri mx^n.y^2 olduğuna göre, m+n toplamı kaçtır?(D) ");
                radioButton[0].setText("64");
                radioButton[1].setText("72");
                radioButton[2].setText("86");
                radioButton[3].setText("94");
                
                }if (current == 112) { 
                label.setText("a ve b pozitif gerçel sayılar olmak üzere,\n" +
"2ax^2-5bx+8b=⍺\n" +
"denkleminin kökleri a ve b’dir.\n" +
" Buna göre, a+b toplamı kaçtır?(C) ");
                radioButton[0].setText("5");
                radioButton[1].setText("6");
                radioButton[2].setText("10");
                radioButton[3].setText("12");
                
                }if (current == 113) { 
                label.setText("Bir çubuk eşit uzunlukta 4 parçaya bölündüğünde her bir\n" +
"parçanın uzunluğu log₅(x) birim, eşit uzunlukta\n" +
"10 parçaya bölündüğünde her bir parçanın uzunluğu\n" +
"log₅(x^2/25) birim olmaktadır.\n" +
"Buna göre, çubuğun uzunluğu kaç birimdir?(A) ");
                radioButton[0].setText("5");
                radioButton[1].setText("8");
                radioButton[2].setText("10");
                radioButton[3].setText("12");
                
                }if (current == 114) { 
                label.setText("n bir tam sayı ve 1<n<100 olmak üzere,\n" +
"log₂(log₃n)\n" +
"ifadesinin değeri bir pozitif tam sayıya eşittir. \n" +
"Buna göre, n sayısının alabileceği değerler toplamı kaçtır?(D) ");
                radioButton[0].setText("45");
                radioButton[1].setText("63");
                radioButton[2].setText("72");
                radioButton[3].setText("90");
                
                }if (current == 115) { 
                label.setText("5 Ekim 2020 Pazartesi ile 18 Ekim 2020 Pazar günleri\n" +
"arasındaki günler ve bu iki gün de dahil olmak üzere,\n" +
"bu 14 gün içinden iki farklı günde birer toplantı\n" +
"yapılacaktır.\n" +
"Toplantılardan en az biri hafta içi olacak biçimde bir\n" +
"düzenleme yapılmak istendiğine göre, bu dü zenleme\n" +
"kaç farklı şekilde yapılabilir?(D) ");
                radioButton[0].setText("70");
                radioButton[1].setText("75");
                radioButton[2].setText("80");
                radioButton[3].setText("85");
                
                }if (current == 116) { 
                label.setText("Sözel ve sayısal bölümlerinde 4’er soru olmak üzere\n" +
"toplam 8 sorudan oluşan bir sınavın kitapçığında\n" +
"“Sınavı geçmek için sözel ve sayısal bölümlerin\n" +
"her birinden en az 2’şer soru olmak üzere\n" +
"toplam en az 5 soruyu doğru cevaplamalısınız.”\n" +
"ifadesi yer almaktadır.\n" +
"Bu ifadeyi eksik okuyan Sevcan, sınavdaki 8 sorudan\n" +
"rastgele 5’ini seçmiş ve seçtiği her bir soruyu doğru\n" +
"cevaplamıştır.\n" +
"Buna göre, Sevcan’ın sınavı geçme olasılığı kaçtır?(D) ");
                radioButton[0].setText("3/4");
                radioButton[1].setText("4/5");
                radioButton[2].setText("5/6");
                radioButton[3].setText("6/7");
                
                }if (current == 117) { 
                label.setText("2tanx-sin(2x)/sin^2.x\n" +
"ifadesinin sadeleştirilmiş biçimi aşağıdakilerden\n" +
"hangisidir?(A) ");
                radioButton[0].setText("2tanx");
                radioButton[1].setText("tan(2x)");
                radioButton[2].setText("2cosx");
                radioButton[3].setText("cos(2x)");
                
                }if (current == 118) { 
                label.setText("Dar açılı bir ABC üçgeninin iç açılarının ölçüleri derece\n" +
"türünden x, y ve z olmak üzere, olduğu\n" +
"biliniyor.\n" +
"Buna göre,\n" +
"a= sin(x+y)\n" +
"b= sin(x+z)\n" +
"c= sin(y+z)\n" +
"sayılarının doğru sıralanışı aşağıdakilerden\n" +
"hangisidir?(A) ");
                radioButton[0].setText("a<b<c");
                radioButton[1].setText("b<a<c");
                radioButton[2].setText("b<c<a");
                radioButton[3].setText("c<a<b");
                
                }if (current == 119) { 
                label.setText("0<x<π/2 olmak üzere,\n" +
"\n" +
"1+tanx/cotx . sinx-cosx/sinx = 2 \n" +
"olduğuna göre, sinx değeri kaçtır?(D) ");
                radioButton[0].setText("1/8");
                radioButton[1].setText("3/5");
                radioButton[2].setText("√2/2");
                radioButton[3].setText("√3/2");
                
                }if (current == 120) { 
                label.setText("Dik koordinat düzleminde bir d doğrusunun A(-4,1)\n" +
"noktasından geçtiği ve 2x-y=5 doğrusuna dik\n" +
"olduğu biliniyor.\n" +
"d doğrusunun x-eksenini kestiği nokta (a,0) ve\n" +
"y-eksenini kestiği nokta (0,b) olduğuna göre,\n" +
"a+b toplamı kaçtır ?(A) ");
                radioButton[0].setText("-3");
                radioButton[1].setText("-1");
                radioButton[2].setText("0");
                radioButton[3].setText("1");
                
                }if (current == 121) { 
                label.setText("Dik koordinat düzleminde A(2,7) ve B(-1,4) noktaları \n" +
"x-ekseni boyunca pozitif yönde 3 birim ötelenerek\n" +
"sırasıyla D ve C noktaları elde ediliyor.\n" +
"Buna göre köşeleri A,B,C ve D noktaları olan \n" +
"dörtgenin alanı kaç birimkaredir?(A) ");
                radioButton[0].setText("9");
                radioButton[1].setText("10");
                radioButton[2].setText("11");
                radioButton[3].setText("12");
                
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
		new programlamadilleri("2017-2020 AYT Matematik Soruları");
	}

}
