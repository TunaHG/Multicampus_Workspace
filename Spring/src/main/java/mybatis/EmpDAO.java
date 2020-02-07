package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}	
	
	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("allemp");
		return list;
	}
	// Test1 : 여러 개 레코드 조회
	// <select id="allemp" resultType="mybatis.EmpVO">
//	for(EmpVO vo:list)	{
//		System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name());
//	}

	public EmpVO getOneEmp(int id) {
		EmpVO vo = session.selectOne("oneemp", id);
		return vo;
	}
	// Test2 : 1개 레코드 조회 (사번이 100인 사람)
//	EmpVO vo = session.selectOne("oneemp", 100);
//	System.out.println(vo.getEmployee_id()+":"+vo.getFirst_name());

	public List<EmpVO> getNameEmp(String name){
		List<EmpVO> list = session.selectList("nameemp", name);
		return list;
	}
	// Test3 : 1개 혹은 그이상의 레코드 조회 (이름이 Steven인 사람)
//	List<EmpVO> list = session.selectList("nameemp", "Steven");
//	for(EmpVO vo:list)	{
//		System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name());
//	}
	
	public List<EmpVO> getIdEmp(){
		List<EmpVO> list = session.selectList("idemp");
		return list;
	}
	// Test4 : CDATA Section 실행
//	List<EmpVO> list = session.selectList("idemp");
//	for(EmpVO vo:list)	{
//		System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name() + ":" + vo.getHire_date());
//	}
	
	// Test5
	public void insertEmp(EmpVO vo) {
		// <insert id="newemp" parameterType="emp"> insert... </insert> 
		session.insert("newemp", vo);
	}
}
