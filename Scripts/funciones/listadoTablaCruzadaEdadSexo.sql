SELECT TA1.edad, CASE WHEN TA1.sexo = 'F' THEN 'FEMENINO' ELSE 'MASCULINO' END AS Sexo, count(TA3.sexo) cantidad
FROM
(
	SELECT ta1.edad, ta2.sexo
	FROM
	(
		SELECT 1 AS edad
		UNION ALL
		SELECT 2 
		UNION ALL
		SELECT 3 
		UNION ALL
		SELECT 4 
		UNION ALL
		SELECT 5 
		UNION ALL
		SELECT 6 
	) AS TA1,
	(
		SELECT 'M' AS sexo
		UNION ALL
		SELECT 'F'
	) AS TA2
) TA1
LEFT JOIN
(
	SELECT 
	  personas_datos_nacimiento.edad, 
	  personas.sexo
	FROM 
	  public.personas_kardex, 
	  public.personas, 
	  public.personas_datos_nacimiento
	WHERE 
	  personas.codigo_persona = personas_kardex.codigo_persona AND
	  personas_datos_nacimiento.codigo_persona = personas.codigo_persona
	  AND personas_datos_nacimiento.edad <= 6
) as TA3
ON TA1.sexo = TA3.sexo
AND TA3.edad = TA1.EDAD
group by TA1.edad, TA1.sexo
order by TA1.edad, TA1.sexo



