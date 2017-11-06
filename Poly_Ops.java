import java.io.*;

class PolyArith 

{

int p3deg1,p1deg,p2deg;
int p1coeff[],p2coeff[];

public void fileRead()
{

try
{

String s;

FileReader fr=new FileReader("input.txt");
BufferedReader br=new BufferedReader(fr);

String s1=br.readLine();
p1deg=Integer.parseInt(s1);



String s2=br.readLine();
String []params1=s2.split(" ");

p1coeff=new int[params1.length];

for(int i=0;i<params1.length;i++)
{

p1coeff[i]=Integer.parseInt(params1[i]);

}//for


String s3=br.readLine();
p2deg=Integer.valueOf(s3);

String s4=br.readLine();
String []params2=s4.split(" ");

p2coeff=new int[params2.length];

for(int i=0;i<params2.length;i++)
{

p2coeff[i]=Integer.valueOf(params2[i]);


}//for


}//try

catch(Exception e)
{

System.out.println(e);

}//catch

}//fileRead method

public void arithematic()
{

try
{

p3deg1=Math.max(p1deg,p2deg);

int p3coeff1[]=new int[p3deg1+1];


if(p1deg>p2deg)
{

for(int j=0;j<p1deg-p2deg;j++)

p3coeff1[j]=p1coeff[j];


for(int i=p1deg-p2deg;i<p3coeff1.length;i++)

p3coeff1[i]=p1coeff[i]+p2coeff[i-(p1deg-p2deg)];


}//if

if(p1deg<p2deg || p1deg==p2deg)
{

for(int j=0;j<p2deg-p1deg;j++)

p3coeff1[j]=p2coeff[j];


for(int i=p2deg-p1deg;i<p3coeff1.length;i++)

p3coeff1[i]=p1coeff[i-(p2deg-p1deg)]+p2coeff[i];

}//if


File f=new File("output.txt");
f.createNewFile();
FileWriter fw=new FileWriter(f,true);

int counter=0;
for(int i=0;i<p3coeff1.length;i++)
{
if(counter==0)
{
if(p3coeff1[i]!=0)
{
counter++;

}//if

}//if

if(counter!=0)

{

fw.write(p3coeff1[i]+" ");

}//if

}//for

fw.write(System.getProperty( "line.separator" ));

if(p1deg>p2deg)
{

for(int j=0;j<p1deg-p2deg;j++)

p3coeff1[j]=p1coeff[j];


for(int i=p1deg-p2deg;i<p3coeff1.length;i++)

p3coeff1[i]=p1coeff[i]-p2coeff[i-(p1deg-p2deg)];


}//if

if(p1deg<p2deg || p1deg==p2deg)
{

for(int j=0;j<p2deg-p1deg;j++)

p3coeff1[j]=-1*p2coeff[j];


for(int i=p2deg-p1deg;i<p3coeff1.length;i++)

p3coeff1[i]=p1coeff[i-(p2deg-p1deg)]-p2coeff[i];

}//if


for(int i=0;i<p3coeff1.length;i++)
fw.append(p3coeff1[i]+" ");
fw.write(System.getProperty( "line.separator" ));

{

int p3deg=p1deg+p2deg;

int p3coeff2[]=new int[p3deg+1];

for(int i=0;i<p1coeff.length;i++)
for(int j=0;j<p2coeff.length;j++)
p3coeff2[i+j]+=p1coeff[i]*p2coeff[j];

for(int i=0;i<p3coeff2.length;i++)
fw.append(p3coeff2[i]+" ");
fw.flush();
fw.close();

}

}//try

catch(Exception e)
{
System.out.println(e);

}

}//multiply method


}//class


class Poly_Ops
{

public static void main(String []args)
{

try
{


PolyArith p1=new PolyArith();
p1.fileRead();
p1.arithematic();

}//try

catch(Exception e)

{
System.out.println(e);

}//catch
}//main
}//class