SELECT F.Fecha,C.Nombre,V.Nombre,F.TipoPago,F.TotalFacturado,F.Nota,F.Descuento
FROM devolucion AS F,persona AS C, persona AS V
WHERE F.idDevolucion=? AND F.Estado='A' AND F.Concepto='Devolucion' AND F.idClienteDev=C.idPersona AND V.idPersona=F.idVendedorDev;


