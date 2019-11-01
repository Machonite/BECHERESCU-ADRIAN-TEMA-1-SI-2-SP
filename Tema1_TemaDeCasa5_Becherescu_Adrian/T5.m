t1=0:0.2:4;                   
a=abs(1.5*sin(2*pi*0.25*t1)); 
subplot(3,1,1)
plot(t1,a),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')

t2=0:0.02:4;
b=abs(1.5*sin(2*pi*0.25*t2));
subplot(3,1,2)
plot(t2,b),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')

t3=0:0.002:4;
c=abs(1.5*sin(2*pi*0.25*t3));
subplot(3,1,3)
plot(t3,c),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')
