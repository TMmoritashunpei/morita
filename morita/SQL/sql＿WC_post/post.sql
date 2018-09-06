
select DISTINCT p1.jis_code,p1.postal_id,p1.postal5,p1.pref_kana,p1.city_kana,p1.pref,p1.city,p1.address,(select flag1 from postal_code_base where postal5 = "64"),(select postal7 from postal_code_base where postal5 = "64") from postal_code p1 join postal_code_base b1 on p1.jis_code = b1.jis_code inner join  postal_code_base b2 on p1.postal7 = b2.postal7 where p1.postal5 between 50 and 90;







select DISTINCT p1.jis_code,p1.postal_id,p1.postal5,p1.pref_kana,p1.city_kana,p1.pref,p1.city,p1.address,(select count(b1.jis_code) from postal_code_base b1),(select count(p1.jis_code) from postal_code p1),(select avg(p1.jis_code) from postal_code p1) from postal_code p1 left join postal_code_base b1 on p1.jis_code = b1.jis_code left join  postal_code_base b2 on p1.postal7 = b2.postal7 left join postal_code p2 on p1.postal5 = p2.postal5  left join postal_code_base b3 on p2.jis_code = b3.jis_code where p1.postal5 between 64 and 65;
