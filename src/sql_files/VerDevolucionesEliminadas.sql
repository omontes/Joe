SELECT Dev.Fecha ,Per.`Nombre` AS Cliente,Dev.`idDevolucion` AS NumDev,
SUM(PCD.`Cantidad`) AS TotalItem,Dev.Descuento,
(Dev.TotalFacturado / (1 - ((Dev.Descuento) / 100))) AS SubTotal,Dev.TotalFacturado
FROM devolucion AS Dev, productocantidaddev AS PCD, persona AS Per
WHERE Dev.Fecha BETWEEN ? AND ? AND 
PCD.`idDevolucion`=Dev.`idDevolucion` AND Dev.`idClienteDev`=Per.`idPersona` 
AND Dev.`Concepto`="Devolucion" AND Dev.`Estado`= "I"
AND Dev.`idVersionDev` = PCD.`idVersionDevProd`
GROUP BY Dev.`idDevolucion`;