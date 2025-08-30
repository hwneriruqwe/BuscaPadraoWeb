/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }

    

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://www.univali.br/");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);

        //mapa do alfabeto
        char[] alfabeto = new char[16];

        alfabeto[0] = '+';
        alfabeto[1] = '(';
        alfabeto[2] = '-';
        alfabeto[3] = ' ';
        alfabeto[4] = '.';
        alfabeto[5] = ')';
        alfabeto[6] = '0';
        alfabeto[7] = '1';
        alfabeto[8] = '2';
        alfabeto[9] = '3';
        alfabeto[10] = '4';
        alfabeto[11] = '5';
        alfabeto[12] = '6';
        alfabeto[13] = '7';
        alfabeto[14] = '8';
        alfabeto[15] = '9';

        //mapa de estados
        String[] estados = new String[29];
        estados[0] = "q0";
        estados[1] = "q1";
        estados[2] = "q2";
        estados[3] = "q3";
        estados[4] = "q4";
        estados[5] = "q5";
        estados[6] = "q6";
        estados[7] = "q7";
        estados[8] = "q8";
        estados[9] = "q9";
        estados[10] = "q10";
        estados[11] = "q11";
        estados[12] = "q12";
        estados[13] = "q13";
        estados[14] = "q14";
        estados[15] = "q15";
        estados[16] = "q16";
        estados[17] = "q17";
        estados[18] = "q18";
        estados[19] = "q19";
        estados[20] = "q20";
        estados[21] = "q21";
        estados[22] = "q22";
        estados[23] = "q23";
        estados[24] = "q24";
        estados[25] = "q25";
        estados[26] = "q26";
        estados[27] = "q27";
        estados[28] = "q28";

        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = new String[16];
        estados_finais[0] = "q9";
        estados_finais[1] = "q12";
        estados_finais[2] = "q13";
        estados_finais[3] = "q14";
        estados_finais[4] = "q15";
        estados_finais[5] = "q16";
        estados_finais[6] = "q18";
        estados_finais[7] = "q19";
        estados_finais[8] = "q20";
        estados_finais[9] = "q21";
        estados_finais[10] = "q22";
        estados_finais[11] = "q24";
        estados_finais[12] = "q25";
        estados_finais[13] = "q26";
        estados_finais[14] = "q27";
        estados_finais[15] = "q28";

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[29][16];
// ---------------- q0 ----------------
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '+')] = get_string_ref(estados, "q1");
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '(')] = get_string_ref(estados, "q6");
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, ')')] = -1;
for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q7");
}
// ---------------- q1 ----------------
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, ')')] = -1;
matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '0')] = -1;
for (char c = '1'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q2");
}
// ---------------- q2 ----------------
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '(')] = get_string_ref(estados, "q6");
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q3");
}
// ---------------- q3 ----------------
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '(')] = get_string_ref(estados, "q6");
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q4");
}
// ---------------- q4 ----------------
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '(')] = get_string_ref(estados, "q6");
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q5");
matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q5");
}
// ---------------- q5 ----------------
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '(')] = get_string_ref(estados, "q6");
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q7");
}
// ---------------- q6 ----------------
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q7");
}
// ---------------- q7 ----------------
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, ')')] = get_string_ref(estados, "q10");

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q8");
}
// ---------------- q8 ----------------
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, ')')] = get_string_ref(estados, "q10");

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q9");
}
// ---------------- q9 ----------------
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q12");
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q12");
matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, ')')] = get_string_ref(estados, "q10");

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q13");
}
// ---------------- q10 ----------------
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q11");
matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q13");
}
// ---------------- q11 ----------------
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q13");
}
// ---------------- q12 ----------------
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q13");
}
// ---------------- q13 ----------------
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q17");
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q14");
}
// ---------------- q14 ----------------
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q17");
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q15");
}
// ---------------- q15 ----------------
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q17");
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q16");
}
// ---------------- q16 ----------------
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q17");
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q18");
matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q19");
}
// ---------------- q17 ----------------
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q19");
}
// ---------------- q18 ----------------
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q18")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q19");
}
// ---------------- q19 ----------------
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q23");
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q19")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q20");
}
// ---------------- q20 ----------------
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q23");
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q20")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q21");
}
// ---------------- q21 ----------------
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q23");
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q21")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q22");
}
// ---------------- q22 ----------------
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q23");
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, ' ')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q24");
matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q22")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q25");
}
// ---------------- q23 ----------------
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q23")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q25");
}
// ---------------- q24 ----------------
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q24")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q25");
}
// ---------------- q25 ----------------
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q25")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q26");
}
// ---------------- q26 ----------------
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q26")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q27");
}
// ---------------- q27 ----------------
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q27")][get_char_ref(alfabeto, c)] = get_string_ref(estados, "q28");
}
// ---------------- q28 ----------------
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, '+')] = -1;
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, '(')] = -1;
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, '-')] = -1;
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, ' ')] = -1;
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, '.')] = -1;
matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, ')')] = -1;

for (char c = '0'; c <= '9'; c++) {
    matriz[get_string_ref(estados, "q28")][get_char_ref(alfabeto, c)] = -1;
}



        
        int estado = get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();


        String palavra = "";

        //varre o código-fonte de um código
        for (int i=0; i<codigoHTML.length(); i++){

            estado_anterior = estado;
            estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
            //se o não há transição
            if (estado == -1){
                //pega estado inicial
                estado = get_string_ref(estados, estado_inicial);
                // se o estado anterior foi um estado final
                if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                    //se a palavra não é vazia adiciona palavra reconhecida
                    if ( ! palavra.equals("")){
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                //zera palavra
                palavra = "";
                
            }else{
                //se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }


        //foreach no Java para exibir todas as palavras reconhecidas
        for (String p: palavras_reconhecidas){
            System.out.println (p);
        }


    }



}
