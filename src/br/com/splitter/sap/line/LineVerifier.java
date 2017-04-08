package br.com.splitter.sap.line;
import java.io.*;

/**
 * Classe responsável por verificar se o primeiro campo da linha do registro estiver em branco.
 * @author Davi Bariani Boin
 */
    public class LineVerifier {
                              
        /**
         * Método que realiza a verificação do conteúdo de um arquivo .csv
         * So o primeiro campo começar erroneamente com "", este será invalidado.
         * @return mensagem de validação para import.
         */
    public  static String lineExaminer(FileReader r){
            
            String message = "";         
            String text= "";
            String line = "";         
            
        try {
       
                  
            BufferedReader reader = new BufferedReader(r);
               
            int first2charac = 2;
            char b[] = new char[first2charac];  
        
        while ((line = reader.readLine()) != null){
                     
           if(reader.read(b) > 0) {
             
               text= new String(b);
                        
               if(text.equals("\"\"")){
               message = "Atenção!!! Linha com problema!";
               break;
               
            }
               else{
                   
               message = "Conteúdo válido para import!";
             
               }
               
               
            }  
                      
         }
        
          r.close();
        } catch ( IOException e) {
        System.out.print(e.getMessage());
        }
        
        return message;
    }
    

    }