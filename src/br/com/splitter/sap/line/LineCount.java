package br.com.splitter.sap.line;
import java.io.*;

/**
 * Classe respons�vel por contar o n�mero de registros (linhas) dentro de um arquivo .csv
 * @author Davi Bariani Boin
 */
public class LineCount {
                         
    /**
         * M�todo que faz a contagem do n�mero de linhas dentro de um arquvo .csv
         * @return n�mero de registros no arquivo .csv
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
        
        // conta o numero de linhas do arquivo, come�a com zero, por isso adiciona 1
        linesNumber = (lineRead.getLineNumber() + 1) -1;
        msg = ("O arquivo cont�m " + linesNumber + " linhas de registros!!!");
        
        } catch (IOException e) {
        
        } 
        
        return msg;
          
    }
    
        }
