package qa.data;
//Pojo class
// plain old jason object class
// we have to marshal ( convert code into jason) by jackson api
public class Users {
	private String name;
	private String job;
	private String id;
	private String created;

	public Users() {
		
	}
public Users(String name,String job,String id,String created) {
        this.name=name;
this.job=job;
this.id=id;
this.created= created;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCreated() {
	return created;
}
public void setCreated(String created) {
	this.created = created;
}





}
