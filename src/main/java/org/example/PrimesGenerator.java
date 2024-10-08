package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimesGenerator implements Iterable<Integer> {
    private final List<Integer> primes;

    public PrimesGenerator(int N) {
        primes = generatePrimes(N);
    }

    private List<Integer> generatePrimes(int N) {
        List<Integer> primesList = new ArrayList<>();
        int number = 2;
        while (primesList.size() < N) {
            if (isPrime(number)) {
                primesList.add(number);
            }
            number++;
        }
        return primesList;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
