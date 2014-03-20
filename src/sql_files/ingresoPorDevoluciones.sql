SELECT SUM(D.TotalFacturado)
FROM devolucion AS D
WHERE D.Estado='A' AND D.Concepto ='Devolucion' AND D.Fecha BETWEEN ? AND ?;
