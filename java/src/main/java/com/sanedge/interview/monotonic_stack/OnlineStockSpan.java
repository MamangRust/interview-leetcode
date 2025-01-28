package com.sanedge.interview.monotonic_stack;

import java.util.Stack;

public class OnlineStockSpan {
  private static class Stock {
    int price;
    int span;

    Stock(int price, int span) {
      this.price = price;
      this.span = span;
    }
  }

  private Stack<Stock> stack;

  public OnlineStockSpan() {
    stack = new Stack<>();
  }

  public int next(int price) {
    int span = 1;

    while (!stack.isEmpty() && stack.peek().price <= price) {
      span += stack.pop().span;
    }

    stack.push(new Stock(price, span));

    return span;
  }

}
