package br.com.splitter.sap.splitscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import br.com.splitter.sap.line.LineCount;
import br.com.splitter.sap.line.LineVerifier;
import br.com.splitter.sap.splitter.SAPSplitter;

import java.io.*;

/**
 * Classe principal que disponibiliza uma interface gráfica para o uso do SAPSplitter
 * @author Davi Bariani Boin
 */
@SuppressWarnings("serial")
public class SplitPanel extends javax.swing.JPanel implements ActionListener {

    private JButton search;
    private JLabel title;
    private JButton confirm;
    private JRadioButton employee;
    private JRadioButton outsource;
    private JTextField fileName;
    protected File file;
    protected static String receive;
    protected static JLabel notice;
    private JLabel mumberLines;
    protected static JLabel notice2;
    protected static JTextField linesSetter;
    private JButton verify;   




public SplitPanel() {
	super();
	initGUI();
}

    /**
     * Método responsável pela construção da interface gráfica
     */
private void initGUI() {
        
	try {
		//FlowLayout thisLayout = new FlowLayout();
		this.setPreferredSize(new java.awt.Dimension(412, 350));
		this.setLayout(null);

		search = new JButton();
        search.addActionListener(this);
        this.add(search);
		search.setLayout(null);
		search.setText("Procurar...");
		search.setBounds(275, 89, 94, 22);                                

        verify = new JButton();
        verify.addActionListener(this);
        this.add(verify);
		verify.setLayout(null);
		verify.setText("Verificar");
		verify.setBounds(275, 150, 94, 22);                                                

		fileName = new JTextField();
		this.add(fileName);
		fileName.setBounds(46, 89, 208, 22);

		employee = new JRadioButton();
        this.add(employee);
        employee.setText("Funcionário");
		employee.setBounds(84, 136, 115, 19);
	
		outsource = new JRadioButton();
		this.add(outsource);
		outsource.setText("Terceiro");
		outsource.setBounds(84, 158, 115, 19);
                        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(employee);
        grupo.add(outsource);

		confirm = new JButton();
		this.add(confirm);
        confirm.addActionListener(this);
		confirm.setText("Ok");
		confirm.setBounds(160, 235, 55, 35);

		title = new JLabel();
		this.add(title);
		title.setText("Selecione o arquivo a ser quebrado e clique em \"Ok\"");
		title.setBounds(58, 40, 297, 15);
		title.setFont(new java.awt.Font("AlArabiya",0,12));
  
        notice= new JLabel();
        this.add(notice);
        notice.setBounds(58, 285, 297, 15);
        notice.setFont(new java.awt.Font("AlArabiya",Font.BOLD,12 ));
        notice.setForeground(Color.red);
 
        linesSetter = new JTextField();
        this.add(linesSetter);
        linesSetter.setBounds(122, 200, 130, 22);
        linesSetter.setText("250");

        mumberLines = new JLabel();
        this.add(mumberLines);
        mumberLines.setText("Linhas:");
        mumberLines.setBounds(58, 203, 297, 15);
        mumberLines.setFont(new java.awt.Font("AlArabiya",0,12));

        notice2 = new JLabel();
        this.add(notice2);
        notice2.setBounds(58, 305, 297, 15);
        notice2.setFont(new java.awt.Font("AlArabiya",Font.BOLD,12 ));
        notice2.setForeground(Color.red);
        
                    
	}

    catch (Exception e) {
		e.printStackTrace();
	}
}
   
/**
 * Método responsável pela ação dos botões
 */
        public void actionPerformed(ActionEvent e){
            
if (e.getSource() == search){
    
    JFileChooser jfc = new JFileChooser();
    jfc.setMultiSelectionEnabled(false);
    jfc.setDialogTitle("Seleção de arquivos");
    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    jfc.getCurrentDirectory();

    jfc.showOpenDialog(this);
            
    file = jfc.getSelectedFile();
    
    receive = file.getName();
        
    fileName.setText(receive);
    }

if (e.getSource() == confirm){
    
            String t = SplitPanel.linesSetter.getText();
            String convert = String.valueOf(t);
            int linhas = Integer.parseInt(convert);

            
            if(outsource.isSelected())
            {
                System.out.println("Iniciando analise do arquivo de Terceiros");
            SAPSplitter.splitFile("TERC",receive,linhas);
            notice.setText("Arquivo quebrado com sucesso!");
        }
        else if (employee.isSelected())
        {
            System.out.println("Iniciando analise do arquivo de Funcionários");
            SAPSplitter.splitFile("FUNC",receive, linhas);
            notice.setText("Arquivo quebrado com sucesso!");
        }
        else
        {
            notice.setText("Erro: Parâmetros de tipo de arquivo inválido!");
            }
                       
    }

if(e.getSource() == verify){
      
   SplitPanel.notice.setText(LineCount.counterLine(new File(SplitPanel.receive)));   
    
   try {
        
        SplitPanel.notice2.setText(LineVerifier.lineExaminer(new FileReader(SplitPanel.receive)));
        
        } catch (FileNotFoundException ex) {
                ex.printStackTrace();
        }
   
    }
        }
        
}