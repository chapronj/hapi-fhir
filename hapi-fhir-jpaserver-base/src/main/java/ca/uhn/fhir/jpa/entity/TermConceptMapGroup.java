package ca.uhn.fhir.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRM_CONCEPT_MAP_GROUP")
public class TermConceptMapGroup implements Serializable {
	@Id()
	@SequenceGenerator(name = "SEQ_CONCEPT_MAP_GROUP_PID", sequenceName = "SEQ_CONCEPT_MAP_GROUP_PID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONCEPT_MAP_GROUP_PID")
	@Column(name = "PID")
	private Long myId;

	@ManyToOne()
	@JoinColumn(name = "CONCEPT_MAP_PID", nullable = false, referencedColumnName = "PID", foreignKey=@ForeignKey(name="FK_TCMGROUP_CONCEPTMAP"))
	private TermConceptMap myConceptMap;

	@Column(name = "SOURCE_URL", nullable = false, length = 200)
	private String mySource;

	@Column(name = "TARGET_URL", nullable = false, length = 200)
	private String myTarget;

	@OneToMany(mappedBy = "myConceptMapGroup")
	private List<TermConceptMapGroupElement> myConceptMapGroupElements;

	public List<TermConceptMapGroupElement> getConceptMapGroupElements() {
		if (myConceptMapGroupElements == null) {
			myConceptMapGroupElements = new ArrayList<>();
		}

		return myConceptMapGroupElements;
	}

	public TermConceptMap getConceptMap() {
		return myConceptMap;
	}

	public void setConceptMap(TermConceptMap theTermConceptMap) {
		myConceptMap = theTermConceptMap;
	}

	public String getSource() {
		return mySource;
	}

	public void setSource(String theSource) {
		this.mySource = theSource;
	}

	public String getTarget() {
		return myTarget;
	}

	public void setTarget(String theTarget) {
		this.myTarget = theTarget;
	}
}
