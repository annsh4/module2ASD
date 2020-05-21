//Блінов В-3
#include <iostream>
#include <clocale>

using namespace std;

struct Node {
    int val;
    Node *prev, *next;

    Node(int _val) : val(_val), prev(nullptr), next(nullptr) {}
};

struct List {
    Node *head = nullptr, *tail = nullptr;

    void add(int val) {
        if (head == nullptr) {
            Node *tmp = new Node(val);
            head = tail = tmp;
        }
        else {
            Node *tmp = new Node(val);
            tail->next = tmp;
            tmp->prev = tail;
            tail = tmp;
        }
    }

    void display() {
        Node* tmp;
        tmp = head;
        while (tmp != nullptr) {
            cout << tmp->val << " ";
            tmp = tmp->next;
        }
        cout << "\n";
    }

    void sort() {
        Node* tmp1 = head;
        while (tmp1 != nullptr) {
            Node* tmp2 = tail;
            while (tmp2 != tmp1) {
                if (tmp2->val < tmp2->prev->val) {
                    int val = tmp2->val;
                    tmp2->val = tmp2->prev->val;
                    tmp2->prev->val = val;
                    continue;
                }
                tmp2 = tmp2->prev;
            }
            tmp1 = tmp1->next;
        }
    }

} list;


int main() {
    setlocale(LC_ALL, "Russian");
    cout << "Введите кол-во элементов списка: " << endl;
    int n;
    cin >> n;
    srand(time(nullptr));
    for (int i = 0; i < n; ++i) {
        list.add(rand() % 20);
    }
    cout << "Сгенерированный список: " << endl;
    list.display();
    list.add(rand() % 20);
    list.sort();
    cout << "Список после сортировки: " << endl;
    list.display();
}
