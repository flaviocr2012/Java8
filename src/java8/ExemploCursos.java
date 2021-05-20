package java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class ExemploCursos {

    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(c -> c.getAlunos()));
        cursos.sort(comparing(Curso::getAlunos));

//        cursos.forEach(curso -> System.out.println(curso.getNome()));

        // cursos com mais de 100 alunos
//        for (Curso curso : cursos) {
//            if (curso.getAlunos() >= 100) {
//                System.out.println(curso);
//            }
//        }
        // usando stream
        int sum = cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
//                .map(Curso::getAlunos)
//                .forEach(System.out::println);
//                .forEach(curso -> System.out.println(curso.getNome()));

//        System.out.println(sum);

        // Optional nos ajuda a trabalhar com null. Ele ajuda a diminuir o números de ifs.
        // Extraí a variável e ele me devolveu um Optional.
        // API do Optional está bem atrelada ao Java 8, streams, Collection
        Optional<Curso> optionalCurso = cursos.stream()
                .filter(c -> c.getAlunos() >= 100) // filtra os cursos com mais de 100 alunos
                .findAny(); // Encontra qualquer curso.
        // Me dê o curso que está aí dentro ou devolva nulo.(orElse)
        // Extraindo a variável, ele devolve um Curso
        Curso curso = optionalCurso.orElse(null);
//        System.out.println(curso.getNome());

//        optionalCurso.ifPresent(curso1 -> {
//            System.out.println(curso1.getNome());
//        });

        // maneira mais clean desse código:
//        cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .findAny()
//                .ifPresent(c -> System.out.println(c.getNome()) );

        // Maneira de guardar um stream é utilizando a Classe Collectors.
        // Dado essa sequência de dados filtrados, colete-os e guarde-os dentro de uma lista.
        // Através dos coletores, conseguimos voltar de um stream pra uma Collection.
        // Guardei os cursos em uma nova lista. Agora ele aponta pra uma nova referência.
        // Os meus cursos valem: os cursos antigos filtrados e coletados em uma nova lista.
//        cursos = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
//                .collect(Collectors.toList());

        // Fazendo a  mesma coisa utilizando  mapa ao invés de lista

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos "));
    }
}
//        System.out.println(map);

        // Ao criar uma nova stream, o sistema volta à Coleção antiga, nesse caso a todos os cursos.
        // O filtro passa a não funcionar.
//        cursos.stream()
//                .forEach(c -> System.out.println(c.getNome()));
//        System.out.println(cursos);






