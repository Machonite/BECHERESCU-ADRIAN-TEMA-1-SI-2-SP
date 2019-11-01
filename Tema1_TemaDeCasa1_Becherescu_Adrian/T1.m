frecventa=1/2;
fact_umplere=0.25;
maximul=0.5;
minimul=-1;
%semnalul dreptunghiular pentru 2ms
a=0:0.002:2;
x=sin(2*pi*frecventa*a);
m=length(x);
for i=1:1:m
   if i<=m*fact_umplere
       x(i)=maximul;
   else
       x(i)=minimul;
   end
end
figure(1)
plot(a,x,'.-'),title('cazul 2ms'),grid
%semnalul dreptunghiular pentru 20ms
b=0:0.02:2;
y=sin(2*pi*frecventa*b);
n=length(y);
for i=1:1:n
    if i<=n*fact_umplere
        y(i)=maximul;
    else
        y(i)=minimul;
    end
end
figure(2)
plot(b,y,'.-'),title('cazul 20ms'),grid
%semnalul dreptunghiular pentru 200ms
c=0:0.2:2;
z=sin(2*pi*frecventa*c);
o=length(z);
for i=1:1:o
    if i<=o*fact_umplere;
        z(i)=maximul;
    else
        z(i)=minimul;
    end
end
figure(3)
plot(c,z,'.-'),title('cazul 200ms'),grid

