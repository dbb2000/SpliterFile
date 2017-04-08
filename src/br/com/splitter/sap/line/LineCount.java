package br.com.splitter.sap.line;
import java.io.*;

/**
 * Classe responsável por contar o número de registros (linhas) dentro de um arquivo .csv
 * @author Davi Bariani Boin
 */
public class LineCount {
                         
    /**
         * Método que faz a contagem do número de linhas dentro de um arquvo .csv
         * @return número de registros no arquivo .csv
         */
        public  static  String counterLine(File readFile){
        
        int linesNumber;
        String msg = "";
            
        try {
               
        // pega o tamanho
        long fileSize = readFile.length();
        FileInputStream fs = new FileInputStream(readFile);
        DataInputStream in = new DataInputStream(fs);


        LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(in));
        lineRead.skip(fileSize);
        
        // conta o numero de linhas do arquivo, começa com zero, por isso adiciona 1
        linesNumber = (lineRead.getLineNumber() + 1) -1;
        msg = ("O arquivo contém " + linesNumber + " linhas de registros!!!");
        
        } catch (IOException e) {
        
        } 
        
        return msg;
          
    }
    
        }
