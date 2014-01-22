SELECT D.Fecha,D.Concepto,D.idDevolucion,D.TipoPago,D.TotalFacturado
FROM devolucion AS D
WHERE D.Estado='A' AND D.Concepto ='Devolucion' AND D.Fecha BETWEEN ? AND ?
ORDER BY D.Concepto,D.TipoPago;
