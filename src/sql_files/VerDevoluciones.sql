SELECT F.`idDevolucion` AS NumFact,F.`Fecha`,C.Nombre AS Cliente,V.Nombre AS Vendedor,TotalFacturado AS Total 
FROM devolucion AS F,persona AS C, persona AS V
WHERE F.`Concepto` ='Devolucion' AND F.`Estado`='A' AND F.`idClienteDev`=C.idPersona AND V.idPersona=F.`idVendedorDev`
ORDER BY F.`idDevolucion` DESC LIMIT 100;
