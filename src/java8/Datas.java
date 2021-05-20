package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate copaDoMundo = LocalDate.of(2022, Month.NOVEMBER, 21);

        int anos = copaDoMundo.getYear() - hoje.getYear();
        System.out.println(anos);

        Period periodo = Period.between(hoje, copaDoMundo);
        System.out.println(periodo.getDays());

        LocalDate proximaCopa = copaDoMundo.plusYears(4);
        System.out.println(proximaCopa);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ValorFormatado = proximaCopa.format(formatador);
        System.out.println(ValorFormatado);

        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorHora));

        LocalDate localDate = agora.toLocalDate();
        System.out.println(localDate);

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);

        LocalTime intervalo2 = LocalTime.of(14, 15);

        boolean after = intervalo.isAfter(intervalo2);
        System.out.println(after);


    }
}
