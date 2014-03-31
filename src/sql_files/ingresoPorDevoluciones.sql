SELECT SUM(D.TotalFacturado)
FROM devolucion AS D
WHERE D.Estado='A' AND D.Concepto ='Devolucion' AND SUBSTRING(D.Fecha,1,10) BETWEEN ? AND ?;
