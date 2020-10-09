import java.util.*;
import java.io.*; 
public class BankRecords extends Client{

    //array of BankRecords objects
    static BankRecords robjs[] = new BankRecords[600]; 
    //arraylist to hold spreadsheet rows & columns
    static ArrayList<List<String>> array = new ArrayList<>();  

    //instance fields
    private String id;
    private int age;
    private String sex;
    private String region;
    private double income;
    private String married;
    private int children;
    private String car;
    private String save_act;
    private String current_act;
    private String mortgage;
    private String pep;

    public void readData() {
        BufferedReader br;
        //initialize reader object and set file path to root of project
        try{
            String line;
            br = new BufferedReader(new FileReader("bankDetail.csv"));
            //read each record in csv file
            while ((line = br.readLine()) != null) {
            //parse each record in csv file by a comma ( , )
            //into a list stored in the arraylist-> Arrays
                array.add(Arrays.asList(line.split(",")));
            }
            processData();  //call function for processing record data
        }
        catch (FileNotFoundException e){
            System.out.println("Exception thrown  :" + e);
        }
        catch (IOException e){
            System.out.println("Exception thrown  :" + e);
        }
    }

    public void processData() {
        //create index for array while iterating thru arraylist
        int idx=0;
        //create for each loop to cycle thru arraylist of values 
        //and PASS that data into your record objects' setters 
        for (List<String> rowData: array) {
            //initialize array of objects
            robjs[idx] = new BankRecords();
            //call setters below and populate them, item by item
            robjs[idx].setId(rowData.get(0)); //get 1st column
            robjs[idx].setAge(Integer.parseInt(rowData.get(1))); //get 2nd column
            robjs[idx].setSex(rowData.get(2));
            robjs[idx].setRegion(rowData.get(3));
            robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
            robjs[idx].setMarried(rowData.get(5));
            robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));
            robjs[idx].setCar(rowData.get(7));
            robjs[idx].setSave_act(rowData.get(8));
            robjs[idx].setCurrent_act(rowData.get(9));
            robjs[idx].setMortgage(rowData.get(10));
            robjs[idx].setPep(rowData.get(11));
     
            /*continue processing arraylist item values into each array object-> robjs[] by index*/
            idx++;
        }
        printData();
    }

    public void printData(){
    	System.out.println("ID\t\tAGE\t\tINCOME\t\tMORTGAGE\tSEX\t\tREGION");
        for(int i = 0; i < 25; i++){
            //System.out.println(robjs[i].toString());
        	if(robjs[i].getIncome() < 99999) { //so long as income is 5 figures is less, we print out the output a certain way
	        	System.out.print(robjs[i].getId() + "\t\t");
	        	System.out.print(robjs[i].getAge() + "\t\t");
	        	System.out.print(robjs[i].getIncome() + "\t\t");
	        	System.out.print(robjs[i].getMortgage() + "\t\t");
	        	System.out.print(robjs[i].getSex() + "\t\t");
	        	System.out.print(robjs[i].getRegion() + "\t\t");
	        	System.out.println();
        	} else { //given the income at line 12 of data, this line has its data not neatly formatted. This else statements solves the issue be removing a "\t" character after getIncome()
        		System.out.print(robjs[i].getId() + "\t\t");
	        	System.out.print(robjs[i].getAge() + "\t\t");
	        	System.out.print(robjs[i].getIncome() + "\t");
	        	System.out.print(robjs[i].getMortgage() + "\t\t");
	        	System.out.print(robjs[i].getSex() + "\t\t");
	        	System.out.print(robjs[i].getRegion() + "\t\t");
	        	System.out.println();
        	}
        }
    }

    public String toString() { //this is the toString() method I originally used for printing data, but because of the 12th row of data I've elected not to use it
        return id + "\t\t" + age + "\t\t" + income + "\t\t" + mortgage +  "\t\t" + sex + "\t\t" + region;
    }
     
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public String getRegion() {
        return region;
    }
    public double getIncome() {
        return income;
    }
    public String getMarried() {
        return married;
    }
    public int getChildren() {
        return children;
    }
    public String getCar() {
        return car;
    }
    public String getSave_act() {
        return save_act;
    }
    public String getCurrent_act() {
        return current_act;
    }
    public String getMortgage() {
        return mortgage;
    }
    public String getPep() {
        return pep;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public void setMarried(String married) {
        this.married = married;
    }
    public void setChildren(int children) {
        this.children = children;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public void setSave_act(String save_act) {
        this.save_act = save_act;
    }
    public void setCurrent_act(String current_act) {
        this.current_act = current_act;
    }
    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }
    public void setPep(String pep) {
        this.pep = pep;
    }

    public static void main(String[] args) {
        Client client = new BankRecords(); //create new Client object of BankRecords
        client.readData();
    }

}
