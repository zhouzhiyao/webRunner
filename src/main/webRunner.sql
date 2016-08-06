
create table testConfig{
	id						varchar(36),				--id
	explorer				varchar(20),				--浏览器
}


--用于测试的用户集
create table userCase{
	id						varchar(36),				--id
	username			varchar(20),				--username
	password			varchar(20)	
}



--页面测试用例集
create table pageTestCase{
	id						varchar(36),				--id
	pageIndex			varchar(100),			--页面的唯一性标识
	inputOrder			int,							--页面内元素测试顺序
	tagName			varchar(10),				--tag元素的名称
	attributeType		varchar(10),				--用于定位元素的属性
	attributeValue		varchar(200),			--属性值
	inputValue			varchar(1000),			--测试用例
	caseType			char(1),					--用例类型： 0 路径引导信息，1 业务信息
	displayName		varchar(100)				--页面显示值
}