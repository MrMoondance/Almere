
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.ListModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField kopjeLijstPlanten;
	int column = 0;
	JList plantenLijst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setBounds(100, 50, 1107, 781);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 560, 39);
		frame.getContentPane().add(toolBar);
		
		JButton btnNewButton = new JButton("Plattegrond");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				plattegrond();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton button = new JButton("Alfabetisch");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alfabetisch();
			}
		});
		toolBar.add(button);
		
		JButton button_1 = new JButton("Maand");
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("Grootte");
		toolBar.add(button_2);
		
		textField = new JTextField();
		toolBar.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		
	}
		
		
	private void plattegrond(){
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(10, 62, 138, 30);
		frame.getContentPane().add(toolBar_1);
		
		JButton btnBomen = new JButton("Bomen");		
		toolBar_1.add(btnBomen);
		
		JButton btnSiertuin = new JButton("Siertuin");
		toolBar_1.add(btnSiertuin);
		
		
		btnBomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bomen();
			}
		});
		btnSiertuin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// hide bomen()
				
				siertuin();
			}
		});
	}
	private void bomen(){
		
		final JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(10, 62, 730, 546);
		
		frame.getContentPane().add(lblNewLabel);
		
		
		ImageIcon Bomen = new ImageIcon("Bomen.jpg");
		
		lblNewLabel.setIcon(Bomen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		frame.getContentPane().add(scrollPane);
		
		final JList bomenLijst = new JList(plattegrondBomenLijst());
		scrollPane.setViewportView(bomenLijst);
		
		bomenLijst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				if (arg0.getValueIsAdjusting()) {	

				
				
				Graphics g = lblNewLabel.getGraphics();
				
				
				switch (bomenLijst.getSelectedValue().toString()) {
					case "A: Carpinus betulus ": 
						g.drawOval(9,37, 45, 45);
						break; 
					case "B: Prunus a. 'Merchant' ": g.drawOval(78,82, 45, 45);	
						System.out.println(bomenLijst.getSelectedValue().toString());
						break;
					case "C: Prunus a. 'Stella' ": g.drawOval(78,171, 45, 45);	break;
					case "D: Prunus d. 'Opal'": g.drawOval(75,261, 45, 45);	break;
					case "E: Prunus d. 'Victoria' ": g.drawOval(77,351, 45, 45);	break;
					case "G: Pyrus c. 'Beurré Hardy'": g.drawOval(170,129, 45, 45);	break;
					case "H: Pyrus c. 'Gieser Wildeman' ": g.drawOval(170,217, 45, 45);	break;
					case "I: Pyrus c. 'Conference' ": g.drawOval(168,309, 45, 45);	break;
					case "J: Malus d. 'Notarisappel' ": g.drawOval(255,82, 45, 45);	break;
					case "K: Malus d. 'Rode Boskoop S.H.' ": g.drawOval(255,172, 45, 45);	break;
					case "L: Malus d. 'Cox's Orange Pippin' ": g.drawOval(254,261, 45, 45);	break;
					case "M: Malus d. 'Ecolette' ": g.drawOval(256,349, 45, 45);	break;
					case "N: Pyrus c. 'Williams' ": g.drawOval(49,439, 45, 45);	break;
					case "O: Pyrus c. 'Saint Rémy' ": g.drawOval(96,438, 45, 45);	break;
					case "P: Pyrus c. 'Kleipeer' ": g.drawOval(142,438, 45, 45);	break;
					case "Q: Malus d. 'Delcorf' ": g.drawOval(189,439, 45, 45);	break;
					case "R: Malus d. 'Luntersche Pippeling' ": g.drawOval(234,439, 45, 45);	break;
					case "S: Malus d. 'Sterappel' ": g.drawOval(280,441, 45, 45);	break;
					case "T: Carpinus betulus ": g.drawOval(317,391, 45, 45);	break;
					case "B1: Ribes nigr. 'Ben Nevis' ": g.drawOval(320,445, 45, 45);	break;
					case "B2: Ribes nigr. 'Titania' ": g.drawOval(336,446, 45, 45);	break;
					case "B3: Ribes nigr. 'Öjebyn' ": g.drawOval(354,447, 45, 45);	break;
					case "B4: Ribes 'Jostaberry' ": g.drawOval(386,446, 45, 45);	break;
					case "B5: Ribes u.-c. 'Captivator' ": g.drawOval(404,447, 45, 45);	break;
					case "B6: Ribes u.-c. 'Hinnonmäki Röd' ": g.drawOval(421,448, 45, 45);	break;
					case "B7: Ribes u.-c. 'Mucurines' ": g.drawOval(438,448, 45, 45);	break;
					case "B8: Ribes u.-c. 'Hinnonmäki Gul' ": g.drawOval(455,447, 45, 45);	break;
					case "B9: Ribes u.-c. 'Remarka' ": g.drawOval(474,447, 45, 45);	break;
					case "B10: Ribes 'Jostaberry' ": g.drawOval(490,448, 45, 45);	break;
					case "B11: Ribes r. 'Jonkheer van Tets'": g.drawOval(606,336, 45, 45);	break;
					case "B12: Ribes r. 'Jonkheer van Tets' ": g.drawOval(607,354, 45, 45);	break;
					case "B13: Ribes r. 'Rovada' ": g.drawOval(606,372, 45, 45);	break;
					case "B14: Ribes r. 'Rovada' ": g.drawOval(606,392, 45, 45);	break;
					case "B15: Ribes r. 'Junifer' ": g.drawOval(606,408, 45, 45);	break;
					case "B16: Ribes r. 'Rondom' ": g.drawOval(606,428, 45, 45);	break;
					case "B17: Ribes r. 'Rotet'": g.drawOval(607,444, 45, 45);	break;
					case "B18: Ribes rub. 'Witte Parel' ": g.drawOval(621,446, 45, 45);	break;
					case "B19: Ribes rub. 'Witte Hollander' ": g.drawOval(639,446, 45, 45);	break;
					case "B20: Ribes r. 'Werdavia' ": g.drawOval(656,445, 45, 45);	break;
			
					default: break;
				}
				
				System.out.println(lblNewLabel.getComponentCount());
				

			
				}
			}
		});
		
		lblNewLabel.addMouseListener(new MouseListener() {
		   

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX()-22;
			    int y=e.getY()-22;
			    System.out.println(x+","+y);//these co-ords are relative to the component
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
			
		
		
	}
	
	
	
	
	private DefaultListModel plattegrondBomenLijst() {
		
		String[] xy = xy();
		
		
		StringBuilder[] lijst = new StringBuilder[45];
		 
		for(int i = 0; i <39; i++) {
			lijst[i] = new StringBuilder("");
			
		}
		lijst[0].append("A");		
		lijst[1].append("B");
		lijst[2].append("C");
		lijst[3].append("D");
		lijst[4].append("E");		
		lijst[5].append("G");
		lijst[6].append("H");
		lijst[7].append("I");
		lijst[8].append("J");
		lijst[9].append("K");
		lijst[10].append("L");
		lijst[11].append("M");
		lijst[12].append("N");
		lijst[13].append("O");
		lijst[14].append("P");
		lijst[15].append("Q");
		lijst[16].append("R");
		lijst[17].append("S");
		lijst[18].append("T");		
		lijst[19].append("B1");
		lijst[20].append("B2");
		lijst[21].append("B3");
		lijst[22].append("B4");
		lijst[23].append("B5");
		lijst[24].append("B6");
		lijst[25].append("B7");
		lijst[26].append("B8");
		lijst[27].append("B9");
		lijst[28].append("B10");
		lijst[29].append("B11");
		lijst[30].append("B12");
		lijst[31].append("B13");
		lijst[32].append("B14");
		lijst[33].append("B15");
		lijst[34].append("B16");
		lijst[35].append("B17");
		lijst[36].append("B18");
		lijst[37].append("B19");
		lijst[38].append("B20");
		
		for (int i = 0; i < lijst.length; i++) {
			if (lijst[i] != null) {
				
			
				
				specificCell(lijst[i].toString(), 0);
				lijst[i].append(": " + specificCell(lijst[i].toString(), 0));
				
			
			}
		}
		
		
		DefaultListModel listModel = new DefaultListModel();		
		for (int i = 0; i < lijst.length; i++) {
			if (lijst[i] != null) {
				String line = lijst[i].toString();
				listModel.addElement(line);  	        
			}
		}
		
	    return listModel;	

	}
		
	
	private void siertuin(){
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 62, 730, 746);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon Siertuin = new ImageIcon("Siertuin.jpg");
		
		
		lblNewLabel.setIcon(Siertuin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		frame.getContentPane().add(scrollPane);
		
		final JList plantenLijst2 = new JList(plattegrondSiertuin());
		scrollPane.setViewportView(plantenLijst2);	
		
		plantenLijst2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				switch (plantenLijst2.getSelectedValue().toString()) {
					case "1: Pyrus c. 'Conference' ": lblNewLabel.getGraphics().drawOval(57,611, 45, 45); break;
					case "2: Echinacea purpurea": lblNewLabel.getGraphics().drawOval(126,622, 45, 45); break;
					case "3: Alcea rosea 'Rosea'": lblNewLabel.getGraphics().drawOval(31,568, 45, 45); break;
					case "4: Pennisetum al. 'Hameln'": lblNewLabel.getGraphics().drawOval(86,568, 45, 45); break;
					case "5: Delphinium (P) 'Galahad' ": lblNewLabel.getGraphics().drawOval(35,532, 45, 45); break;
					case "6: Geranium 'Rozanne' ": lblNewLabel.getGraphics().drawOval(131,541, 45, 45); break;
					case "7: Lavandula ang. 'Hidcote' ": lblNewLabel.getGraphics().drawOval(73,501, 45, 45); break;
					case "8: Lavandula ang. 'Hidcote' ": lblNewLabel.getGraphics().drawOval(102,448, 45, 45); break;
					case "9: Aster (D) 'Alice Haslam'": lblNewLabel.getGraphics().drawOval(38,419, 45, 45); break;
					case "10: Caryopteris cl. 'Grand Bleu' ": lblNewLabel.getGraphics().drawOval(27,367, 45, 45); break;
					case "11: Pennisetum al. 'Hameln'": lblNewLabel.getGraphics().drawOval(135,385, 45, 45); break;
					case "12: Caryopteris cl. 'Grand Bleu' ": lblNewLabel.getGraphics().drawOval(106,376, 45, 45); break;
					case "13: Salvia nemorosa 'Schneehuegel'": lblNewLabel.getGraphics().drawOval(109,341, 45, 45); break;
					case "14: Salvia nemorosa 'Schneehuegel' ": lblNewLabel.getGraphics().drawOval(53,318, 45, 45); break;
					case "15: Pachysandra term. 'Green Carpet' ": lblNewLabel.getGraphics().drawOval(105,304, 45, 45); break;
					case "16: Persicaria ampl. 'Blackfield' ": lblNewLabel.getGraphics().drawOval(32,268, 45, 45); break;
					case "17: Pennisetum al. 'Little Bunny' ": lblNewLabel.getGraphics().drawOval(101,233, 45, 45); break;
					case "18: Aster (D) 'Jenny'": lblNewLabel.getGraphics().drawOval(67,206, 45, 45); break;
					case "19: Hydrangea pan. 'Little Lime' ": lblNewLabel.getGraphics().drawOval(98,194, 45, 45); break;
					case "20: Imperata cylindrica 'Red Baron' ": lblNewLabel.getGraphics().drawOval(136,175, 45, 45); break;
					case "21: Gaura lindh. 'Whirling Butterflies'": lblNewLabel.getGraphics().drawOval(31,182, 45, 45); break;
					case "22: Pyrus c. 'Conference'": lblNewLabel.getGraphics().drawOval(58,118, 45, 45); break;
					case "23: Verbena bonariensis ": lblNewLabel.getGraphics().drawOval(114,137, 45, 45); break;
					case "24: Gaura lindh. 'Whirling Butterflies'": lblNewLabel.getGraphics().drawOval(111,94, 45, 45); break;
					case "25: Perovskia atriplicif. 'Blue Spire' ": lblNewLabel.getGraphics().drawOval(178,95, 45, 45); break;
					case "26: Campanula pers. 'Alba' ": lblNewLabel.getGraphics().drawOval(158,130, 45, 45); break;
					case "27: Rosa (P) 'The Fairy' ": lblNewLabel.getGraphics().drawOval(185,168, 45, 45); break;
					case "28: Platycodon grand. 'Albus' ": lblNewLabel.getGraphics().drawOval(226,120, 45, 45); break;
					case "29: Viburnum davidii ": lblNewLabel.getGraphics().drawOval(240,149, 45, 45); break;
					case "30: Miscanthus sin. 'Kleine Silbersp.' ": lblNewLabel.getGraphics().drawOval(270,103, 45, 45); break;
					case "31: Geranium 'Rozanne' ": lblNewLabel.getGraphics().drawOval(276,155, 45, 45); break;
					case "32: Nepeta faassenii ": lblNewLabel.getGraphics().drawOval(316,120, 45, 45); break;
					case "33: Nepeta faassenii ": lblNewLabel.getGraphics().drawOval(430,119, 45, 45); break;
					case "34: Hosta for. 'Francee'": lblNewLabel.getGraphics().drawOval(480,96, 45, 45); break;
					case "35: Hydrangea pan. 'Little Lime' ": lblNewLabel.getGraphics().drawOval(473,135, 45, 45); break;
					case "36: Pennisetum al. 'Hameln'": lblNewLabel.getGraphics().drawOval(502,122, 45, 45); break;
					case "37: Carex osh. 'Evergreen' ": lblNewLabel.getGraphics().drawOval(526,151, 45, 45); break;
					case "38: Campanula posch. 'E.H. Frost'": lblNewLabel.getGraphics().drawOval(540,168, 45, 45); break;
					case "39: Gaura lindh. 'Whirling Butterflies'": lblNewLabel.getGraphics().drawOval(573,127, 45, 45); break;
					case "40: Acer pal. 'Atropurpureum' ": lblNewLabel.getGraphics().drawOval(533,99, 45, 45); break;
					case "41: Verbena bonariensis ": lblNewLabel.getGraphics().drawOval(567,96, 45, 45); break;
					case "42: Geranium 'Rozanne' ": lblNewLabel.getGraphics().drawOval(594,89, 45, 45); break;
					case "43: Lonicera henryi ": lblNewLabel.getGraphics().drawOval(569,60, 45, 45); break;
					case "44: Rosa 'Guirlande d'Amour'": lblNewLabel.getGraphics().drawOval(476,62, 45, 45); break;
					case "45: Rosa 'Guirlande d' Amour' ": lblNewLabel.getGraphics().drawOval(279,61, 45, 45); break;
					case "46: Fallopia baldschuanica ": lblNewLabel.getGraphics().drawOval(189,60, 45, 45); break;
					case "47: Clematis 'Multi Blue' ": lblNewLabel.getGraphics().drawOval(97,61, 45, 45); break;
					case "48: Lonicera per. 'Belgica' ": lblNewLabel.getGraphics().drawOval(5,61, 45, 45); break;										
				}
		
			}
				
		});
			
		
		
		
		lblNewLabel.addMouseListener(new MouseListener() {
			   

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX()-22;
			    int y=e.getY()-22;
			    System.out.println(x+","+y);//these co-ords are relative to the component
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		
	}
	
	
	private DefaultListModel plattegrondSiertuin() {
		
		StringBuilder[] lijst = new StringBuilder[48];
		 
		for(int i = 0; i <48; i++) {
			lijst[i] = new StringBuilder("");
			
		}
		String[] xy = xy();		
		lijst[0].append("1");
		lijst[1].append("2");
		lijst[2].append("3");
		lijst[3].append("4");
		lijst[4].append("5");
		lijst[5].append("6");
		lijst[6].append("7");
		lijst[7].append("8");
		lijst[8].append("9");
		lijst[9].append("10");
		lijst[10].append("11");
		lijst[11].append("12");
		lijst[12].append("13");
		lijst[13].append("14");
		lijst[14].append("15");
		lijst[15].append("16");
		lijst[16].append("17");
		lijst[17].append("18");
		lijst[18].append("19");
		lijst[19].append("20");
		lijst[20].append("21");
		lijst[21].append("22");
		lijst[22].append("23");
		lijst[23].append("24");
		lijst[24].append("25");
		lijst[25].append("26");
		lijst[26].append("27");
		lijst[27].append("28");
		lijst[28].append("29");
		lijst[29].append("30");
		lijst[30].append("31");
		lijst[31].append("32");
		lijst[32].append("33");
		lijst[33].append("34");
		lijst[34].append("35");
		lijst[35].append("36");
		lijst[36].append("37");
		lijst[37].append("38");
		lijst[38].append("39");
		lijst[39].append("40");
		lijst[40].append("41");
		lijst[41].append("42");
		lijst[42].append("43");
		lijst[43].append("44");
		lijst[44].append("45");
		lijst[45].append("46");
		lijst[46].append("47");
		lijst[47].append("48");
		
		for (int i = 0; i < lijst.length; i++) {
			if (lijst[i] != null && xy[i] != null) {
				
				lijst[i].append(": " + specificCell(lijst[i].toString(), 0));
				
				
			System.out.println("case \"" + lijst[i].toString() + "\": lblNewLabel.getGraphics().drawOval(" + xy[i].toString() + ", 45, 45); break;");

			//String temp = lijst[i].toString() 
			//case "1: Pyrus c. 'Conference' ": lblNewLabel.getGraphics().drawOval(57.611, 45, 45); 
			}
		}
		
		
		
		DefaultListModel listModel = new DefaultListModel();		
		for (int i = 0; i < lijst.length; i++) {
			if (lijst[i] != null) {
				String line = lijst[i].toString();
				listModel.addElement(line);  	        
			}
		}
	    return listModel;	
	}
		
		
	private void alfabetisch(){
			
		
		JPanel alfabetisch = new JPanel();
		alfabetisch.setBounds(0, 53, 1079, 577);
		frame.getContentPane().add(alfabetisch);
		
	
		
		
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 152, 295, 356);
		alfabetisch.add(scrollPane);
		plantenLijst = new JList(oneRow(column));
		plantenLijst.setSelectionMode(1);
		
		
		
		
		scrollPane.setViewportView(plantenLijst);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(330, 152, 627, 456);
		alfabetisch.add(scrollPane_1);
		
		final JTextPane plantInfo = new JTextPane();
		plantInfo.setEditable(false);
		scrollPane_1.setViewportView(plantInfo);
		
		kopjeLijstPlanten = new JTextField();
		kopjeLijstPlanten.setEditable(false);
		kopjeLijstPlanten.setText("Lijst van groene dingen");
		kopjeLijstPlanten.setBounds(49, 101, 169, 39);
		alfabetisch.add(kopjeLijstPlanten);
		kopjeLijstPlanten.setColumns(10);		
		
		
		final Button button_3 = new Button("Sorteren op referentie");
		
		button_3.setBounds(330, 101, 276, 23);
		alfabetisch.add(button_3);
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (column == 0) {
					button_3.setLabel("Sorteren op Plantnaam");
					column = 5;
				} else {
					column = 0;	
					button_3.setLabel("Sorteren op Referentie");
					
				}
				plantenLijst = new JList(oneRow(column));
				scrollPane.setViewportView(plantenLijst);
								
				plantenLijst.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						plantInfo.setText(plantenlijstChange());
						
						
						
					}
				});
				
				
			}
		});
		
		plantenLijst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				plantInfo.setText(plantenlijstChange());
				
				
				
			}
		});
	}
		
	
	private ListModel oneRow(int column) {
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(1);
		    HSSFRow row;
		    HSSFCell cell;
		    
		    DefaultListModel listModel = new DefaultListModel();
		        
		    
		    int rows = 1000; // No of rows
		    int cols = 6; // No of columns
		    
		    for(int r = 11; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	cell = row.getCell((short)column);
		        	if(cell != null) {
		        		listModel.addElement(cell.toString());
		        	}
		                
		            
		        }
		    }
		   
		    
		    return listModel;
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private String[][] allRows(String plant, int column) {
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(1);
		    HSSFRow row;
		    HSSFCell cell;
		    
		    String[][] eigenschappen = new String[15][6]; 
		    int rows = 1000; // No of rows
		    

		    int cols = 6; // No of columns
		   

		    
		    int a = 0;
		    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	if (row.getCell(column).toString().equals(plant)) {
		        		for(int c = 0; c < cols; c++) {
		        			cell = row.getCell((short)c);
		        			if(cell != null) {
		        				eigenschappen[a][c]= cell.toString();
		        			}
		                }
		        		a++;
		            }
		        }
		    }
		    return eigenschappen;
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		
		
		return null;
		
	}
	private String plantenlijstChange() {
		String[] kop =  {"Plantnaam: ", "Maat: ","Aantal: ", "Prijs: ", "Bedrag: "};
		
		
		String[][] array = allRows(plantenLijst.getSelectedValue().toString(), column);				
		StringBuilder tekst = new StringBuilder("Plant: \n");
		int counter = 0;
		for (int a = 0; a < 15; a++) {		
			if (array[a][0] != null) {
				counter ++;
			}
		}
		
		if (array[0][5].toString().equals("A") && column == 5) {
			
			
			for (int a = 0; a < counter; a++) {
				
			
				for (int i = 0; i < 5; i++) {
				
					tekst.append(kop[i] + array[a][i] + "\n");
				}
			}
			tekst.append("Referenties:" );
			tekst.append(" A");
			return tekst.toString();
		} else {
			
		
			for (int i = 0; i < 5; i++) {
				
				tekst.append(kop[i] + array[0][i] + "\n");
							
			}
		//op referentie zoeken = meerdere plantennamen bij A laten zien
			tekst.append("Referenties:" );
		
			for (int a = 0; a < counter; a++) {
				tekst.append(" " + array[a][5]);
			}
		
		
			return tekst.toString();
		}
	}
	private String specificCell(String referentie, int requestedColumn) {
	
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(1);
		    HSSFRow row;
		    HSSFCell cell;
		    
		    
		    
		    int rows = 1000; // No of rows
		    int cols = 6; // No of columns		    
		    for(int r = 11; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	for (int c = 0; c < cols; c++) {	
		        		cell = row.getCell((short)c);
		        		if (cell.toString().equals(referentie)) {		        			
		        			return row.getCell(requestedColumn).toString();
		        		 
		        		}
		        	}
		                
		            
		        }
		    }
		   
		    
		    
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
		
		
		
		
		
		
		
		
		return null;
		
	}
	private String[] xy() {
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(2);
		    HSSFRow row;
		    HSSFCell cell;
		    
		    
		    String[] xy = new String[50];
		    int rows = 50; // No of rows
		    int cols = 1; // No of columns		    
		    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	xy[r] = row.getCell(0).toString();       			
		        		
		        		 
		        		
		        	
		                
		            
		        }
		    }
		return xy;
		    
		    
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
		
		
		
		
		
		
		
		
		
		
	}
	private void draw(int x, int y) {
		
	}
}
