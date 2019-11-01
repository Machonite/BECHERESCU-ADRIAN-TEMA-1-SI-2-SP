%mai intai am creat un vector cu valori generate aleatoriu folosind comanda v=randn(n) in fereastra command window . Am ales sa fie 21 la numar
v=randn(1,21)

%am continuat in fisier folosind algoritmul de verificare a fiecarui element din vector sa fie mai mic decat 0
for i=1:1:21
    if v(i)<0
        disp(v(i))
    end
end

% disp(v(i)) afiseaza elementul de pe pozitia i din vector care indeplineste conditia data
