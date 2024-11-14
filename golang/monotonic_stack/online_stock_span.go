package main

type StockSpanner struct {
	stack []struct {
		price int
		span  int
	}
}

func Constructor() StockSpanner {
	return StockSpanner{}
}

func (this *StockSpanner) Next(price int) int {
	span := 1

	for len(this.stack) > 0 && this.stack[len(this.stack)-1].price <= price {
		span += this.stack[len(this.stack)-1].span

		this.stack = this.stack[:len(this.stack)-1]
	}

	this.stack = append(this.stack, struct {
		price int
		span  int
	}{price, span})

	return span
}
