package br.com.splitter.sap.line;
import java.io.*;

/**
 * Classe respons�vel por verificar se o primeiro campo da linha do registro estiver em branco.
 * @author Davi Bariani Boin
 */
    public class LineVerifier {
                              
        /**
         * M�todo que realiza a verifica��o do conte�do de um arquivo .csv
         * So o primeiro campo come�ar erroneamente com "", este ser� invalidado.
         * @return mensagem de valida��o para import.
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
               message = "Aten��o!!! Linha com problema!";
               break;
               
            }
               else{
                   
               message = "Conte�do v�lido para import!";
             
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