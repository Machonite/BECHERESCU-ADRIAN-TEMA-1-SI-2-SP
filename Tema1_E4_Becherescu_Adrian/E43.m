a=-15:25;
x1=sin(pi*a/17);
b=0:50;
x2=cos(pi*b/sqrt(23));
figure(1)
stem(x1),grid
hold on
stem(x2),grid
%reprezentarea graficului in stem
figure(2)
subplot(2,1,1),plot(x1),grid
subplot(2,1,2),plot(x2),grid
%reprezentarea graficului in plot
figure(3)
subplot(2,1,1),stem(x1),grid
subplot(2,1,2),stem(x2),grid
%reprezentarea graficului in plot
%observam faptul ca vom avea 3 grafice reprezentate