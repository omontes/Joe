SELECT D.Fecha,D.Concepto,D.idDevolucion,0.00,D.TotalFacturado
FROM devolucion AS D
WHERE D.Estado='A' AND D.Concepto ='Devolucion' AND D.Fecha BETWEEN ? AND ?
ORDER BY D.Concepto;
