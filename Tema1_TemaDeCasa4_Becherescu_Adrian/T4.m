a=0:0.2:3;
x=0.8*sin(2*pi*0.333*a);
for i=1:1:length(x);      
    if x(i)<0;
        x(i)=0;
    end
end
subplot(3,1,1)
plot(a,x),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')



b=0:0.02:3;
y=0.8*sin(2*pi*0.333*b);
for i=1:1:length(y);
    if y(i)<0;
        y(i)=0;
    end
end
subplot(3,1,2)
plot(b,y),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')


c=0:0.002:3;
z=0.8*sin(2*pi*0.333*c);
for i=1:1:length(z);
    if z(i)<0;
        z(i)=0;
    end
end
subplot(3,1,3)
plot(c,z),grid
xlabel('Time(sec)')
ylabel('Amplitude(V)')
