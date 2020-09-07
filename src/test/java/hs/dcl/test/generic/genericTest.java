package hs.dcl.test.generic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class genericTest {

    @Test
    void Pair() {

        Set a = new HashSet();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        System.out.println(a);
    }
}
