package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.out;
import static java.util.Comparator.*;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("alura on line");
        palavras.add("Casa do Código");
        palavras.add("Caelum");

//        Comparator<String> comparador = new ComparadorPorTamanho();

        // java 7
//        Collections.sort(palavras, comparador);
        // java 8 - Essas duas expressões são equivalentes
//        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // palavras, compare o tamanho da string.
        // O lambda faz o seguinte: dado um objeto, invoca o método do objeto
        palavras.sort(Comparator.comparing(s -> s.length()));
        // Quero invocar o método length da String. É chamado de método reference.
        // Método é uma maneira de escrever lambda de uma maneira mais clara.
        palavras.sort(comparing(String::length)); // Essa maneira é muito utilizada. Ela é mais tipada.

        // As proximas linhas são a extração das variáveis acima. Criação da Function, Comparator e fazendo o sort.
        // Dada uma String, me retorna o tamanho dela. Ao invés de receber uma nova função, posso colocar lambda
        // ou método reference
        Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Comparator<String> comparador = comparing(funcao);
        palavras.sort(comparador);

        out.println(palavras);

        // java 7
//        for (String p : palavras) {
//            System.out.println(p);
//        }
        // java 8
//        palavras.forEach(p -> {
//            System.out.println(p);
//        });

        // classe anônima -> utilizada quando se tem poucas linhas e/ou métodos. Quando não for aproveitar o código.
//        Consumer<String> consumidor = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

//        Consumer<String> consumidor = new ImprimenaLinha();
        // foreach recebe um consumidor de strings
        // Métodos default como o foreach permite que ele tenha corpo. Esses métodos permitem
        // que voce adicione um novo método concreto. Foreach herda da interface Consumer.
        // se dentro das chaves, eu tenho apenas um comando, eu posso tirá-las.

        // A expressão lambda consegue ser convertida pra uma interface funcional.
        // Expressão lambda recebe um argumento e devolve void.
        // São expressões equivalentes.

//        Consumer<String> impressor = s -> System.out.println(s);
        // Pega o System e converte para um Consumer
        Consumer<String> impressor = System.out::println;
        palavras.forEach(impressor);

        // Esse modelo é utilizado para um único método.
        palavras.forEach(x -> out.println(x));
        palavras.forEach(out::println);




    }
}
