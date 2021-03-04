package com.algo;

public class PangramChecker {

  public boolean solution(String sentence) {
    return sentence.toLowerCase().chars().filter(ch -> ch >= 'a' && ch <= 'z').distinct().count()
        == 26;
  }
}
