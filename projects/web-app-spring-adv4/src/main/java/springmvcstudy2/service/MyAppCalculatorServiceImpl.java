package springmvcstudy2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyAppCalculatorServiceImpl implements MyAppCalculatorService {

    private static final Map<Integer, String> RESULTS;
    static {
        RESULTS = new HashMap<>();
        RESULTS.put(0, "NORMAL");
        RESULTS.put(1, "GOOD");
        RESULTS.put(2, "EXCELLENT");
    }

    @Override
    public String calculate(String name1, String name2) {
        return RESULTS.get((name1.length() + name2.length()) % 3);
    }
}
