
import java.util.Date;
import java.util.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
int i,len=0;	
	LinkedList<Student> list=new LinkedList<Student>();
	public StudentGroup(int length) {
		this.students = new Student[length];
	len=length;
        }

	
	public Student[] getStudents() {
                
		return students;
	}


	public void setStudents(Student[] students) throws IllegalArgumentException {
	
        if(students!=null){
           for(i=0;i<list.size();i++)list.add(students[i]);
        }
        else{
            throw new IllegalArgumentException();
        }
	}


	public Student getStudent(int index)  throws IllegalArgumentException{
		if(index>=0&&index<list.size())return list.get(index);
         else{
            throw new IllegalArgumentException();
        }
	}

	
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		if(index>=0&&index<list.size())list.set(index, student);
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void addFirst(Student student) throws IllegalArgumentException{
		list.set(0, student);
	
        }

	
	public void addLast(Student student) {
	list.set((list.size()-1), student);
	}


	public void add(Student student, int index)throws IllegalArgumentException {
		
                if(index>=0&&index<list.size())list.set(index, student);
                  else{
            throw new IllegalArgumentException();
        }
                
               
	}

	
	public void remove(int index) throws IllegalArgumentException{
		if(index>=0&&index<list.size())list.remove(index);
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void remove(Student student)throws IllegalArgumentException {
	int f=0;
            if(student!=null){
            for(i=0;i<list.size();i++)
            {
                if(list.get(i)==student)
                {
                    list.set(i,null);
               f=1;
                    break;
                }
            }
        }
        if(f==0)System.out.println("Student not exist");
        else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeFromIndex(int index) throws IllegalArgumentException{
		
            if(index>=0&&index<list.size()){
                  list.remove(index);
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeFromElement(Student student)  throws IllegalArgumentException{
	int f=0;
            if(student!=null){
           for(i=0;i<list.size();i++)if(list.get(i)==student)break;
           while(i<list.size()){
               if(list.get(i)==student)list.set(i,null);
               i++;
           }
	}
        else{
            throw new IllegalArgumentException();
        }
        }
	
	public void removeToIndex(int index) throws IllegalArgumentException{
		if(index>=0&&index<list.size()){
                    for(i=index+1;i<list.size();i++)list.set(i,null);
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void removeToElement(Student student) throws IllegalArgumentException{
		if(student!=null){
                    for(i=0;i<list.size();i++)if(list.get(i)==student)break;
                    while(i<list.size()){
                        if(list.get(i)==student)list.set(i, null);
                    }
                }
	else{
            throw new IllegalArgumentException();
        }
        }

	
	public void bubbleSort() {
		int j;
                Student temp;
                for(i=0;i<list.size();i++){
                    for(j=i+1;j<list.size();j++){
                        if(list.get(i).getId()>list.get(j).getId()){
                            temp=list.get(i);
                            list.set(i,list.get(j));
                            list.set(j,temp);
                        }
                    }
                }
	}

	
	public Student[] getByBirthDate(Date date)throws IllegalArgumentException {
		if(date!=null){
                    Student[] birth=new Student[list.size()];
                
                int j=0;
                for(i=0;i<list.size();i++){
                  if(date.compareTo(list.get(i).getBirthDate())<=0)birth[j++]=list.get(i);
                    
                }
		return birth;
        }
                
                else{
            throw new IllegalArgumentException();
        }
	}

	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		Student[] birth=new Student[list.size()];
                int j=0;
                if(firstDate!=null&&lastDate!=null){
                for(i=0;i<list.size();i++){
                    if(firstDate.compareTo(list.get(i).getBirthDate())>=0&&lastDate.compareTo(list.get(i).getBirthDate())<=0)birth[j++]=list.get(i);
                }
		return birth;
                }
        
                else{
            throw new IllegalArgumentException();
        }        
        }

	
	public Student[] getNearBirthDate(Date date, int days)throws IllegalArgumentException {
	if(date!=null){	
            Student[] birth=new Student[list.size()];
                int j=0;
                for(i=0;i<list.size();i++){
                    if(date.compareTo(list.get(i).getBirthDate())<=days)birth[j++]=list.get(i);
                }
		return birth;
        }
	
                else{
            throw new IllegalArgumentException();
        }        
        }

	
	public int getCurrentAgeByDate(int indexOfStudent) {
            Date age=null;
            if(indexOfStudent!=0){
                    Date date=list.get(indexOfStudent).getBirthDate();
                    long agein=new Date().getTime()-date.getTime();
                 age=new Date(agein);
                
                }
	return age.getYear();
        }

	
	public Student[] getStudentsByAge(int age) {
		Student[] birth=new Student[list.size()];
          
		return null;
	}

	
	public Student[] getStudentsWithMaxAvgMark() {
	double max=-1;
        int j=0;
        Student[] marks=new Student[list.size()];
              for(i=0;i<list.size();i++)if(max<list.get(i).getAvgMark())max=list.get(i).getAvgMark();
              for(i=0;i<list.size();i++)if(max==list.get(i).getAvgMark())marks[j++]=list.get(i);
               
              		return marks;
	}

	
	public Student getNextStudent(Student student)throws IllegalArgumentException {
		if(student!=null){
                    for(i=0;i<list.size();i++)if(list.get(i)==student)break;
        	return list.get(i+1);            
                }
	
	else{
            throw new IllegalArgumentException();
        }        
        }
}
