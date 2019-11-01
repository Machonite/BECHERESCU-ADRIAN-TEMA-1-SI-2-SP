function[m,x,M]=functie( v )
m=real(sum(v))/length(v)
%pentru media aritmetica a numerelor complexe, mai intai am facut suma
%elementelor din vector folosind sum(v),dupa care am extras partea reala a
%acestei sume folosind real(sum(v)),pe care am impartit-o la cate elemente
%are vectorul
x=v.^2
%am creat un nou vector care contine toate elementele vectorului v ridicate
%la patrat
M=v*v.'
%am creat o  matrice obþinutã din inmulþirea vectorului initial cu transpusul sau
end