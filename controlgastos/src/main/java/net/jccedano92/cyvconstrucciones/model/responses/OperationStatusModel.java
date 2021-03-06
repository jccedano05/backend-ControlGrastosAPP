package net.jccedano92.cyvconstrucciones.model.responses;

public class OperationStatusModel<T> {

	private String name;
	
	private String result;
	
	private T dataObject;
	
	public OperationStatusModel (T newClass) {
		
		dataObject = newClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public T getDataObject() {
		return dataObject;
	}

	public void setDataObject(T classInstance) {
		this.dataObject = classInstance;
	}
	
	
	
	
}
