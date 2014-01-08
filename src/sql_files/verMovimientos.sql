select M.Fecha, M.Detalle, M.CantidadMovida as Cantidad, M.Balance as Balance
,TM.tipo as Tipo
from movimientos as M
inner join tipomovimiento as TM 
on TM.idTipoMovimiento=M.idTipoMovimiento order by M.Fecha;