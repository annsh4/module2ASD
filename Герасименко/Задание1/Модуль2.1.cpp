#include <iostream>
#include <set>

using namespace std;

class Stack {
private:
	int* data = nullptr;
	size_t size_ = 0;
	size_t top = 0;
	set<int> max_elements;
public:
	Stack(size_t size = 10) {
		data = new int[size];
		size_ = size;
	}
	~Stack() {
		delete[] data;
	}
	void push(int value) {
		if (top >= size_) {
			cout << "Stack is full!" << endl;
			return;
		}
		data[top] = value;
		top++;
	}
	int pop() {
		if (top <= 0) {
			cout << "Stack is empty!" << endl;
			return -1;
		}
		int temp = data[--top];
		size_--;
		return temp;
	}
	set<int> getMaxElement() {
		int max = data[0];
		for (int i = 1; i < top; ++i) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		max_elements.insert(max);
		return max_elements;
	}
	size_t size() {
		return size_;
	}
};

ostream& operator <<(ostream& stream, set<int> s) {
	for (auto i : s) {
		stream << i << ", ";
	}
	stream << endl;
	return stream;
}

int main()
{
	int n;
	cin >> n;
	Stack s(n);
	while (n) {
		int op = 0;
		cin >> op;
		if (op == 1) {
			int value;
			cin >> value;
			s.push(value);
		}
		else if (op == 2) {
			cout << "Element " << s.pop() << " deleted." << endl;
		}
		else if (op == 3) {
			cout << "Max element is: " << s.getMaxElement() << endl;
		}
		else {
			cout << "Unknown token" << endl;
		}
	}
}



