/**
 * 
 */

class Jumin{
	
	//내부변수 : _변수명

	//생성자(Constructor)
	constructor(jumin_no){
		this._jumin_no = jumin_no;
	}
	
	//getter
	get jumin_no(){
		return this._jumin_no;
	}
	
	//setter
	set jumin_no(jumin_no){
		this._jumin_no = jumin_no;
	}
	

	//출생년도 구하기
	getYear(){
		
		var my_year = parseInt(this._jumin_no.substr(0,2));
		var check = Number(this._jumin_no.charAt(7));
		
		this._check = check;
		
		if(check == 1|| check == 2|| check == 5|| check == 6){
			my_year += 1900;
		}
			
		else if(check == 3|| check == 4|| check == 7|| check == 8){
			my_year += 2000;
			}
		//전역변수 만들기
		this._my_year = my_year;

		return my_year;
		
	}

	getGender(){

		if(this._check%2 == 0){
			return "여성";
		}else{
			return "남성";
		} 
	}	
	getSeason(){		
		var month = Number(this._jumin_no.substr(2,2));
		
		this._month = month;

		switch(Math.floor(month/3)){
			case 1 : return "봄";
			case 2 : return "여름";
			case 3 : return "가을";
			default : return "겨울";				
		}

	}
 
	getAge(){
		
		var date = new Date();
		
		//var year = date.getFullYear();
		
		
		var age =(date.getYear() + 1900) - this._my_year + 1;
		
		
		var myMonth = date.getMonth()+1;
		
		var 만나이 = 0;		
		if(myMonth<this._month){
			만나이 = age - 2;
		}else 만나이 = age - 1;
		
		
		return age+"세" + " " +"(만"+만나이+"세)" ;
		
	}
	
	
	
	
	getGanji(){
		
		var a = this._my_year%10;
		var b = this._my_year%12;
		
		var gan;
		var ji;
		//배열로 해도 된다..
		switch (a) { // 10간
		case  0 : gan = "경"; break;
		case  1 : gan = "신"; break;
		case  2 : gan = "임"; break;
		case  3 : gan = "계"; break;
		case  4 : gan = "갑"; break;
		case  5 : gan = "을"; break;
		case  6 : gan = "병"; break;
		case  7 : gan = "정"; break;
		case  8 : gan = "무"; break;
		case  9 : gan = "기"; break;
		default : gan = "";
		}
		switch (b) { // 12지
		case  0 : ji = "신"; break;
		case  1 : ji = "유"; break;
		case  2 : ji = "술"; break;
		case  3 : ji = "해"; break;
		case  4 : ji = "자"; break;
		case  5 : ji = "축"; break; 
		case  6 : ji = "인"; break;
		case  7 : ji = "묘"; break;
		case  8 : ji = "진"; break;
		case  9 : ji = "사"; break;
		case 10 : ji = "오"; break;
		case 11 : ji = "미"; break;
		default : ji = "";
		}
		
		return (gan+ji+"년");
		
	}

	
	getTti(){
			
		var my_Tti = this._my_year%12;
		
		//배열로 해도 된다..
		switch (my_Tti) {
		case  0 : return "원숭이";
		case  1 : return "닭";
		case  2 : return "개";
		case  3 : return "돼지";
		case  4 : return "쥐";
		case  5 : return "소";
		case  6 : return "호랑이";
		case  7 : return "토끼";
		case  8 : return "용";
		case  9 : return "뱀";
		case 10 : return "말";
		}	
		return "양";
		
	}

	getLocal(){
		var local =  parseInt(this._jumin_no.substring(8,10));

		if(local>=0 &&local<=8)			return "서울특별시";
		else if(local>=9 && local<=12)	return "부산광역시";
		else if(local>=13 && local<=15)	return "인천광역시";
		else if(local>=16 && local<=25)	return "경기도";
		else if(local>=26 && local<=34) return "강원도";
		else if(local>=35 && local<=39) return "충청북도";
		else if(local==40)				return "대전광역시";
		else if(local==44 || local==49) return "세종특별시";
		else if(local>=41 && local<=43 || 
				local>=45 && local<=47) return "충청남도";
		else if(local>=48 && local<=54) return "전라북도";
		else if(local>=55 && local<=56) return "광주광역시";
		else if(local>=57 && local<=66) return "전라남도";
		else if(local>=67 && local<=70) return "대구광역시";
		else if(local>=71 && local<=81) return "경상북도";
		else if(local==85 || local==90) return "울산광역시";
		else if(local>=82 && local<=92) return "경상남도";
		else if(local>=93 && local<=95) return "제주특별시";
		return "";
				
	}
	
	getReal(){
		
		var sum = 0;
		var count = 2;
		
		for(var i=0; i<=this._jumin_no.length-1; i++){
			//하이폰 만나면
			if(i==6) continue;
			
			sum += parseInt(this.jumin_no.charAt(i))*count;
			count++;
		
			//뒷자리 9넘어가면 다시 2로..
			if(count>9){
				count = 2;
			}
		}
		sum = (11-sum%11) % 10;
		
		if(sum==parseInt(this.jumin_no.charAt(13))){
			return "정확한 주민번호";
		}else return "잘못된 주민번호"
		
	}
	
	
	
	
}