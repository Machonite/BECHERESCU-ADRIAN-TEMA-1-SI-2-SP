Niveluri = 4; 
%avem din cerinta 4 niveluri
a=0.001;
m=0:a:Niveluri;
j=1;
for i=1:length(m)
  if  m(i)<=j*0.25
      if j<=length(m)
         x(i)=m(j);
         else
             x(i)=0;
         end
     else
        if j<=length(m)
             x(i)=m(j);
        end
        j=j+1; 
     end
    end
    axis([0 20 -5 3])
    plot(m,x);
