package custom_enum_annotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class cl = reader.readLine().equals("Rank") ? Rank.class : Suit.class ;
        CardInfo cardInfo = (CardInfo) cl.getAnnotation(CardInfo.class);
        System.out.printf("Type = %s, Description = %s", cardInfo.type(), cardInfo.description());


    }
}
